package project.main;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.AccDao;
import project.dao.DepDao;
import project.dao.MemDao;
import project.dao.WithDao;
import project.dto.AccDto;
import project.dto.DepDto;
import project.dto.MemDto;
import project.dto.WithDto;
import project.dto.joinDto;

public class PJMain {
	static Scanner scan = new Scanner(System.in);
	static MemDao daoM = new MemDao();
	static AccDao daoA = new AccDao();
	static WithDao daoW = new WithDao();
	static DepDao daoD = new DepDao();

	public static void main(String[] args) {
		e: while (true) {
			System.out.println("<< ��ȣ�� �����ּ���. >>");
			System.out.println("[1.ȸ������] [2.���µ��] [3.ȸ����������] [4.ȸ������] [5.����ȸ����ȸ] [6.��üȸ����ȸ]");
			System.out.println("[7.���⳻���߰�] [8.���Գ����߰�] [9.��ü��ݳ�������] [10.��ü�Աݳ�������] [0.����]");
			int n = scan.nextInt();
			switch (n) {
			case 1:
				addMem();
				break;
			case 2:
				addAcc();
				break;
			case 3:
				update();
				break;
			case 4:
				delMem();
				break;
			case 5:
				search();
				break;
			case 6:
				viewAll();
				break;
			case 7:
				addWith();
				break;
			case 8:
				addDep();
				break;
			case 9:
				withAll();
				break;
			case 10:
				depAll();
				break;
			case 0:
				System.out.println("<< ���α׷��� �����մϴ�. >>");
				break e;
			default:
				System.out.println("<< ----- �߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���. ----- >>");
			}
		}

	}

	// ȸ������
	public static void addMem() {
		System.out.println("ȸ����ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		System.out.println("�������� �̸��� �Է��� �ּ���");
		String name = scan.next();
		System.out.println("��й�ȣ�� �Է��� �ּ���");
		String pw = scan.next();
		System.out.println("�̸����� �Է��� �ּ���");
		String email = scan.next();
		MemDto dto = new MemDto(num, name, pw, email);
		daoM.addMem(dto);
	}

	// ���µ��
	public static void addAcc() {
		System.out.println("ȸ����ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		System.out.println("����� ������ ������ �Է��� �ּ���");
		String bank = scan.next();
		System.out.println("���¹�ȣ�� �Է��� �ּ���");
		String accnum = scan.next();
		System.out.println("���� �ܾ��� �Է��� �ּ���");
		int amount = scan.nextInt();
		AccDto dto = new AccDto(num, bank, accnum, amount);
		daoA.addAcc(dto);
	}

	// ȸ����������
	public static void update() {
		System.out.println("�����ϰ��� �ϴ� ȸ���� ��ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		System.out.println(num + "�� ȸ���� ������ ��й�ȣ�� �Է��� �ּ���");
		String pw = scan.next();
		System.out.println(num + "�� ȸ���� ������ �̸��ϸ� �Է��� �ּ���");
		String email = scan.next();
		MemDto dto = new MemDto(num, null, pw, email);
		int n = daoM.update(dto);
		if (n == 1) {
			System.out.println("<< ȸ�������� �����Ǿ����ϴ�. >>");
		} else {
			System.out.println("<< ȸ������ ������ �����߽��ϴ�. >>");
		}
	}

	// ȸ������
	public static void delMem() {
		System.out.println("������ ȸ���� ��ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		int n = daoM.delMem(num);
		if (n == 1) {
			System.out.println("<< Ż��Ǿ����ϴ�. >>");
		} else {
			System.out.println("<< Ż�� �����߽��ϴ�. >>");
		}
	}

	// ����ȸ����ȸ
	public static void search() {
		System.out.println("��ȸ�� ȸ���� ��ȣ�� �Է��ϼ���");
		int num = scan.nextInt();
		joinDto dto = daoM.search(num);
		if (dto != null) {
			System.out.println("<< ��ȸ�� ȸ������ >>");
			System.out.println("ȸ����ȣ: " + dto.getNum() + " / �̸�: " + dto.getName() + " / ��й�ȣ: " + dto.getPw()
					+ " / �̸���: " + dto.getEmail() + " / ���¹�ȣ: " + dto.getAccnum() + " / �ܾ�: " + dto.getAmount() + "��");
			System.out.println("==============================================");
		} else {
			System.out.println("<< ��ȸ�� ȸ���� �����ϴ�. >>");
		}
	}

	// ��üȸ����ȸ
	public static void viewAll() {
		ArrayList<joinDto> list = daoM.viewAll();
		System.out.println("<< ��üȸ����ȸ >>");
		for (int i = 0; i < list.size(); i++) {
			joinDto dto = list.get(i);
			System.out.println("ȸ����ȣ: " + dto.getNum() + " / �̸�: " + dto.getName() + " / ��й�ȣ: " + dto.getPw()
					+ " / �̸���: " + dto.getEmail() + " / ���¹�ȣ: " + dto.getAccnum() + " / �ܾ�: " + dto.getAmount() + "��");
		}
		System.out.println(
				"==================================================================================================");
	}

	// ���⳻���߰�
	public static void addWith() {
		System.out.println("��� ������ �߰��� ȸ���� ��ȣ�� �Է��� �ּ���.");
		int num = scan.nextInt();
		System.out.println("��� ������ �Է��� �ּ���. ��)Ŀ�� ");
		String category = scan.next();
		System.out.println("��� �ݾ��� �Է��� �ּ���.");
		int money = scan.nextInt();
		WithDto dto = new WithDto(num, null, category, money);
		daoW.addWith(dto);
	}

	// ���Գ����߰�
	public static void addDep() {
		System.out.println("�Ա� ������ �߰��� ȸ���� ��ȣ�� �Է��� �ּ���.");
		int num = scan.nextInt();
		System.out.println("�Ա� ������ �Է��� �ּ���. ��)�޿�");
		String category = scan.next();
		System.out.println("�Ա� �ݾ��� �Է��� �ּ���");
		int money = scan.nextInt();
		DepDto dto = new DepDto(num, null, category, money);
		daoD.addDep(dto);
	}

	// ��ü���⳻������
	public static void withAll() {
		System.out.println("��ü ��ݳ����� �ñ��� ȸ���� ��ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		ArrayList<WithDto> list = daoW.withAll(num);
		int tot = 0;
		if (list != null) {
			System.out.println("<< ��ȸ�� ȸ���� ��ü ��ݳ��� >>");
			for (int i = 0; i < list.size(); i++) {
				WithDto dto = list.get(i);
				tot = dto.getMoney() + tot;
				System.out.println(
						"��¥: " + dto.getCadate() + " / ����: " + dto.getCategory() + " / �ݾ�: " + dto.getMoney() + "��");
			}
			System.out.println("�� ����ݾ�: " + tot + "��");
			System.out.println("==============================================");
		} else {
			System.out.println("<< ��ȸ�� ���⳻���� �����ϴ�. >>");
			System.out.println("============================");
		}
	}

	// ��ü���Գ�������
	public static void depAll() {
		System.out.println("��ü �Աݳ����� �ñ��� ȸ���� ��ȣ�� �Է��� �ּ���");
		int num = scan.nextInt();
		ArrayList<DepDto> list = daoD.depAll(num);
		int tot = 0;
		if (list != null) {
			System.out.println("<< ��ȸ�� ȸ���� ��ü �Աݳ��� >>");
			for (int i = 0; i < list.size(); i++) {
				DepDto dto = list.get(i);
				tot = dto.getMoney() + tot;
				System.out.println(
						"��¥: " + dto.getCadate() + " / ����: " + dto.getCategory() + " / �ݾ�: " + dto.getMoney() + "��");
			}
			System.out.println("�� ���Աݾ�: " + tot + "��");
			System.out.println("==============================================");
		} else {
			System.out.println("<< ��ȸ�� ���Գ����� �����ϴ�. >>");
			System.out.println("============================");
		}
	}
}
