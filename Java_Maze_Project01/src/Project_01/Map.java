package Project_01;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

// 1
public class Map {
	private Scanner m; // �̷θ� �׸� �ؽ�Ʈ ������ ������ �о�� �� �ִ� ��ĳ�� ���
	private String Map[] = new String[25];
	private Image wall, way, finish;
	// �̹��� ����� ���ִ� awt ��Ű���� Image �޼ҵ�

	public Map() {
		// ImageŬ������ ImageIconŬ������ �ٸ� Ŭ����.
		// ImageIcon�� ���� ���� �̹���, �� �������� �̹��� ��ü�� ����� ��
		// ImageIcon ����� : �����ڷ� ��θ� �Ѱ��ָ� �ȴ� (��ü ����)
		ImageIcon imgB = new ImageIcon("wall.png");
		wall = imgB.getImage();
		// ������ ��ü�� ImageŬ������ ��ü�� ���� �����ϴ� �޼ҵ��� getImage()
		ImageIcon imgG = new ImageIcon("way.png");
		way = imgG.getImage();
		ImageIcon imgF = new ImageIcon("finish.png");
		finish = imgF.getImage();

		getFile();
	}

	// --- �̹��� ��ü�� �����ϴ� �޼ҵ� --- //
	public Image getWall() {
		return wall;
	}

	public Image getWay() {
		return way;
	}

	public Image getFinish() {
		return finish;
	}

	// ���� ��ġ�� �˱� ���� �޼ҵ� - f�� �����ߴ��� �� �ߴ��� Ȯ���ϱ� ����
	public String getMap(int x, int y) {
		String index = Map[y].substring(x, x + 1);
		// x���� x+1���� �ڸ��� x�� ���´�. x�� �ε����� ������ ���
		return index; // �ε��� ����
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
