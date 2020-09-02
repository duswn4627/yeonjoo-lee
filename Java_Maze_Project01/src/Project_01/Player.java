package Project_01;

import java.awt.Image;
import javax.swing.ImageIcon;
// 2
public class Player {
	private int tileX, tileY; // ���� ���� �׷��� ����
	// �̹��� ����� ���ִ� awt ��Ű���� Image �޼ҵ�
	private Image player;

	public Player() { // ������
		// ImageŬ������ ImageIconŬ������ �ٸ� Ŭ����.
		// ImageIcon�� ���� ���� �̹���, �� �������� �̹��� ��ü�� ����� ��
		// ImageIcon ����� : �����ڷ� ��θ� �Ѱ��ָ� �ȴ� (��ü ����)
		ImageIcon img = new ImageIcon("player.png");
		player = img.getImage();
		// ������ ��ü�� ImageŬ������ ��ü�� ���� �����ϴ� �޼ҵ��� getImage() ȣ��

		// player ������(�̻��ؾ�)�� ������ �� ���� ��ġ ����
		tileX = 1;
		tileY = 1;
		// tileX, tileY�� �̻��ؾ��� ���� ��ġ�� ����Ų��
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

	// �̻��ؾ��� ������ �� �ְ� �ϴ� �޼ҵ�
	// �̻��ؾ��� ������ ������ ��ǥ���� �ٲ�� �ϴ� �޼ҵ�
	public void move(int dx, int dy) {
		tileX += dx;
		tileY += dy;
	}
}
