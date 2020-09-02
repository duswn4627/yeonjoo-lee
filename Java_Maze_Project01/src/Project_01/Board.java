package Project_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
// 3
// JPanel�� ActionLIstener�� ���߻�� ���� Board Ŭ����
public class Board extends JPanel implements ActionListener {
	private Timer t; // Swing��Ű�� �ȿ� TimerŬ������ ���
	// Timer Ŭ���� : ������ �����ð� ��� �Ŀ� �ϳ� �̻��� �׼��̺�Ʈ�� �߻���Ų��

	private Map m; // Map Ŭ���� ����
	private Player p; // Player Ŭ���� ����
	private boolean clear = false; // ������ ������ �� ȭ�� ��ȯ(���� ȭ�� ����)�ϱ� ���� �ο���
	private String msg = ""; // ȭ�� ��ȯ�ؼ� �����ٰ� �޽��� â �߰� �� ����
	// �ڹٿ��� �⺻������ �����ϴ� �ټ� ���� �� �ϳ� ��Ʈ ����
	private Font font = new Font("Serif", Font.BOLD, 160);
	public static boolean end = true; // ������ ������ �� �ð��� ���߰� �ϱ� ���� �ο���

	public Board() { // ������
		m = new Map(); // Ŭ���� ȣ��
		p = new Player();
		addKeyListener(new Move());
		setFocusable(true);

		// Ÿ�̸� ������ �Ķ���� -> (�и��ʴ���, �ڱ��ڽ�)
		t = new Timer(25, this);
		// �и��� ������ ������ �ð��� ����ϸ�, Timer�� �׼� �̺�Ʈ�� �ڵ������� ����
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// getMap �޼ҵ��� �Ķ���� -> (int x, int y)
		if (m.getMap(p.getTileX(), p.getTileY()).equals("f")) { // ���� ��ġ�� f��
			// tileX, tileY�� �̻��ؾ��� ���� ��ġ�� ����Ų��
			clear = true; // ȭ�� ��ȯ
			msg = "CLEAR"; // �޽���â ����
			end = false; // �ð��� ���߱�
		}
		// �������� �����ϰ� ������ ���� ������ �ٽ� �׷��ִ� �޼ҵ�
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (!clear) { // ȭ���� �� ��������
			for (int x = 0; x < 25; x++) {
				for (int y = 0; y < 25; y++) {
					if (m.getMap(x, y).equals("f")) {
						// drawImage(Image img, int x, int y, ImageObserver observer)
						g.drawImage(m.getFinish(), x * 32, y * 32, null); // ���
					}
					if (m.getMap(x, y).equals("��")) {
						g.drawImage(m.getWay(), x * 32, y * 32, null); // ��
					}
					if (m.getMap(x, y).equals("��")) {
						g.drawImage(m.getWall(), x * 32, y * 32, null); // ��
					}
				}
			}
			g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null); // �̻��ؾ�
		}
		if (clear) { // ȭ���� ��������
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(msg, 160, 420); // ��ġ
		}
	}

	// Ű����� �����ϰų� Ư�� Ű�� ������ �����Ͱ� �����ϰ� �ϴ� Ű����͸� ��ӹ��� Move Ŭ����
	public class Move extends KeyAdapter {
		// Ű �Է��� �߻����� �� ��Ÿ���� �̺�Ʈ�� KeyEvent �������̵�
		@Override
		public void keyPressed(KeyEvent e) {
			// MazeFrameŬ������ wait�� ��ŸƮ ��ư ������ ���� ����Ű ��Ȱ��ȭ ������ ��
			if (MazeFrame.wait == false)
				return;

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("��")) {
					p.move(0, -1);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("��")) {
					p.move(0, 1);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("��")) {
					p.move(-1, 0);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("��")) {
					p.move(1, 0);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}
