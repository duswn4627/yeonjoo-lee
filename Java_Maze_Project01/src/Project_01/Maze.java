package Project_01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 4
//GUI 구현 클래스
class MazeFrame extends JFrame {
	JPanel panelMap = new JPanel(); // 미로가 있을 패널
	JPanel panelSide = new JPanel(); // 스타트 버튼과 시간초 라벨이 있을 패널
	JButton btnStart = new JButton("START"); // 스타트 버튼
	JLabel lblSec = new JLabel(); // 시간초를 붙일 라벨

	public static boolean wait = false; // 스타트 버튼 누르기 전에 방향키 비활성화

	public MazeFrame() { // 생성자
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

		class SecThread extends Thread { // 시간초를 위한 스레드
			int time = -1; // 0초부터 시작하도록

			@Override
			public void run() { // 스레드는 run메소드 반드시 오버라이딩
				while (true) {
					if (!Board.end) { // Board클래스의 end(시간초) 호출
						break; // 멈춰라
					}
					time++;
					lblSec.setText(time + "초");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}
			}
		}
		SecThread thread = new SecThread();

		// 스타트 버튼 액션 리스너
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStart) {
					btnStart.setEnabled(false); // 버튼 비활성화
					wait = true; // 방향키 활성화
					thread.start(); // 시간초 스레드 실행
				}
			}
		};
		btnStart.addActionListener(listener); // 버튼 액션리스터 활성화
	}
}

public class Maze {
	public static void main(String[] args) {
		new MazeFrame();
	}
}