package Project_01;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

// 1
public class Map {
	private Scanner m; // 미로를 그린 텍스트 파일의 내용을 읽어올 수 있는 스캐너 사용
	private String Map[] = new String[25];
	private Image wall, way, finish;
	// 이미지 출력을 해주는 awt 패키지의 Image 메소드

	public Map() {
		// Image클래스와 ImageIcon클래스는 다른 클래스.
		// ImageIcon은 아주 작은 이미지, 즉 아이콘을 이미지 객체로 만들어 줌
		// ImageIcon 사용방법 : 생성자로 경로를 넘겨주면 된다 (객체 생성)
		ImageIcon imgB = new ImageIcon("wall.png");
		wall = imgB.getImage();
		// 생성한 객체를 Image클래스의 객체로 만들어서 리턴하는 메소드인 getImage()
		ImageIcon imgG = new ImageIcon("way.png");
		way = imgG.getImage();
		ImageIcon imgF = new ImageIcon("finish.png");
		finish = imgF.getImage();

		getFile();
	}

	// --- 이미지 객체를 리턴하는 메소드 --- //
	public Image getWall() {
		return wall;
	}

	public Image getWay() {
		return way;
	}

	public Image getFinish() {
		return finish;
	}

	// 현재 위치를 알기 위한 메소드 - f에 도달했는지 안 했는지 확인하기 위함
	public String getMap(int x, int y) {
		String index = Map[y].substring(x, x + 1);
		// x에서 x+1까지 자르면 x가 나온다. x를 인덱스란 변수에 담고
		return index; // 인덱스 리턴
	}

	public void getFile() {
		try {
			m = new Scanner(new File("Map.txt"));
			while (m.hasNext()) {
				for (int i = 0; i < 25; i++) {
					Map[i] = m.next();
				}
			}
			m.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
