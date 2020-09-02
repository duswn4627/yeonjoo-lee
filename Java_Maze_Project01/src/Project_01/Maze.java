package Project_01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 4
//GUI ���� Ŭ����
class MazeFrame extends JFrame {
	JPanel panelMap = new JPanel(); // �̷ΰ� ���� �г�
	JPanel panelSide = new JPanel(); // ��ŸƮ ��ư�� �ð��� ���� ���� �г�
	JButton btnStart = new JButton("START"); // ��ŸƮ ��ư
	JLabel lblSec = new JLabel(); // �ð��ʸ� ���� ��

	public static boolean wait = false; // ��ŸƮ ��ư ������ ���� ����Ű ��Ȱ��ȭ

	public MazeFrame() { // ������
		super("Maze Game");
		setLayout(new BorderLayout());
		add(panelMap, BorderLayout.CENTER);
		panelSide.add(btnStart);
		panelSide.add(lblSec);
		add(panelSide, BorderLayout.EAST);
		add(new Board());
		setSize(930, 842);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		class SecThread extends Thread { // �ð��ʸ� ���� ������
			int time = -1; // 0�ʺ��� �����ϵ���

			@Override
			public void run() { // ������� run�޼ҵ� �ݵ�� �������̵�
				while (true) {
					if (!Board.end) { // BoardŬ������ end(�ð���) ȣ��
						break; // �����
					}
					time++;
					lblSec.setText(time + "��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}
			}
		}
		SecThread thread = new SecThread();

		// ��ŸƮ ��ư �׼� ������
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStart) {
					btnStart.setEnabled(false); // ��ư ��Ȱ��ȭ
					wait = true; // ����Ű Ȱ��ȭ
					thread.start(); // �ð��� ������ ����
				}
			}
		};
		btnStart.addActionListener(listener); // ��ư �׼Ǹ����� Ȱ��ȭ
	}
}

public class Maze {
	public static void main(String[] args) {
		new MazeFrame();
	}
}