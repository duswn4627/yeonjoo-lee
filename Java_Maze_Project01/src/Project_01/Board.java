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
// JPanel과 ActionLIstener를 다중상속 받은 Board 클래스
public class Board extends JPanel implements ActionListener {
	private Timer t; // Swing패키지 안에 Timer클래스을 사용
	// Timer 클래스 : 지정된 지연시간 경과 후에 하나 이상의 액션이벤트를 발생시킨다

	private Map m; // Map 클래스 선언
	private Player p; // Player 클래스 선언
	private boolean clear = false; // 게임이 끝났을 때 화면 전환(게임 화면 끄기)하기 위한 부울형
	private String msg = ""; // 화면 전환해서 끝났다고 메시지 창 뜨게 할 거임
	// 자바에서 기본적으로 제공하는 다섯 가지 중 하나 폰트 적용
	private Font font = new Font("Serif", Font.BOLD, 160);
	public static boolean end = true; // 게임이 끝났을 때 시간초 멈추게 하기 위한 부울형

	public Board() { // 생성자
		m = new Map(); // 클래스 호출
		p = new Player();
		addKeyListener(new Move());
		setFocusable(true);

		// 타이머 생성자 파라미터 -> (밀리초단위, 자기자신)
		t = new Timer(25, this);
		// 밀리초 단위로 지정된 시간이 경과하면, Timer는 액션 이벤트를 자동적으로 수행
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// getMap 메소드의 파라미터 -> (int x, int y)
		if (m.getMap(p.getTileX(), p.getTileY()).equals("f")) { // 현재 위치가 f면
			// tileX, tileY는 이상해씨의 현재 위치를 가르킨다
			clear = true; // 화면 전환
			msg = "CLEAR"; // 메시지창 띄우기
			end = false; // 시간초 멈추기
		}
		// 움직임을 감지하고 움직인 곳의 프레임 다시 그려주는 메소드
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (!clear) { // 화면이 안 꺼졌으면
			for (int x = 0; x < 25; x++) {
				for (int y = 0; y < 25; y++) {
					if (m.getMap(x, y).equals("f")) {
						// drawImage(Image img, int x, int y, ImageObserver observer)
						g.drawImage(m.getFinish(), x * 32, y * 32, null); // 깃발
					}
					if (m.getMap(x, y).equals("□")) {
						g.drawImage(m.getWay(), x * 32, y * 32, null); // 길
					}
					if (m.getMap(x, y).equals("■")) {
						g.drawImage(m.getWall(), x * 32, y * 32, null); // 벽
					}
				}
			}
			g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null); // 이상해씨
		}
		if (clear) { // 화면이 꺼졌으면
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(msg, 160, 420); // 위치
		}
	}

	// 키보드로 선택하거나 특정 키를 누르면 리스터가 동작하게 하는 키어댑터를 상속받은 Move 클래스
	public class Move extends KeyAdapter {
		// 키 입력이 발생했을 때 나타내는 이벤트인 KeyEvent 오버라이딩
		@Override
		public void keyPressed(KeyEvent e) {
			// MazeFrame클래스의 wait는 스타트 버튼 누르기 전에 방향키 비활성화 설정한 것
			if (MazeFrame.wait == false)
				return;

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("■")) {
					p.move(0, -1);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("■")) {
					p.move(0, 1);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("■")) {
					p.move(-1, 0);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("■")) {
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
