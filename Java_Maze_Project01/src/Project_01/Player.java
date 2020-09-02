package Project_01;

import java.awt.Image;
import javax.swing.ImageIcon;
// 2
public class Player {
	private int tileX, tileY; // 벽과 길을 그려줄 변수
	// 이미지 출력을 해주는 awt 패키지의 Image 메소드
	private Image player;

	public Player() { // 생성자
		// Image클래스와 ImageIcon클래스는 다른 클래스.
		// ImageIcon은 아주 작은 이미지, 즉 아이콘을 이미지 객체로 만들어 줌
		// ImageIcon 사용방법 : 생성자로 경로를 넘겨주면 된다 (객체 생성)
		ImageIcon img = new ImageIcon("player.png");
		player = img.getImage();
		// 생성한 객체를 Image클래스의 객체로 만들어서 리턴하는 메소드인 getImage() 호출

		// player 아이콘(이상해씨)의 시작할 때 고정 위치 설정
		tileX = 1;
		tileY = 1;
		// tileX, tileY는 이상해씨의 현재 위치를 가르킨다
	}

	public Image getPlayer() {
		return player;
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}

	// 이상해씨를 움직일 수 있게 하는 메소드
	// 이상해씨가 움직일 때마다 좌표값도 바뀌게 하는 메소드
	public void move(int dx, int dy) {
		tileX += dx;
		tileY += dy;
	}
}
