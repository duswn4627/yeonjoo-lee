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
			System.out.println("<< 번호를 눌러주세요. >>");
			System.out.println("[1.회원가입] [2.계좌등록] [3.회원정보수정] [4.회원삭제] [5.선택회원조회] [6.전체회원조회]");
			System.out.println("[7.지출내역추가] [8.수입내역추가] [9.전체출금내역보기] [10.전체입금내역보기] [0.종료]");
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
				System.out.println("<< 프로그램을 종료합니다. >>");
				break e;
			default:
				System.out.println("<< ----- 잘못 입력했습니다. 다시 입력하세요. ----- >>");
			}
		}

	}

	// 회원가입
	public static void addMem() {
		System.out.println("회원번호를 입력해 주세요");
		int num = scan.nextInt();
		System.out.println("가입자의 이름을 입력해 주세요");
		String name = scan.next();
		System.out.println("비밀번호를 입력해 주세요");
		String pw = scan.next();
		System.out.println("이메일을 입력해 주세요");
		String email = scan.next();
		MemDto dto = new MemDto(num, name, pw, email);
		daoM.addMem(dto);
	}

	// 계좌등록
	public static void addAcc() {
		System.out.println("회원번호를 입력해 주세요");
		int num = scan.nextInt();
		System.out.println("등록할 계좌의 은행을 입력해 주세요");
		String bank = scan.next();
		System.out.println("계좌번호를 입력해 주세요");
		String accnum = scan.next();
		System.out.println("현재 잔액을 입력해 주세요");
		int amount = scan.nextInt();
		AccDto dto = new AccDto(num, bank, accnum, amount);
		daoA.addAcc(dto);
	}

	// 회원정보수정
	public static void update() {
		System.out.println("수정하고자 하는 회원의 번호를 입력해 주세요");
		int num = scan.nextInt();
		System.out.println(num + "번 회원의 수정할 비밀번호를 입력해 주세요");
		String pw = scan.next();
		System.out.println(num + "번 회원의 수정할 이메일를 입력해 주세요");
		String email = scan.next();
		MemDto dto = new MemDto(num, null, pw, email);
		int n = daoM.update(dto);
		if (n == 1) {
			System.out.println("<< 회원정보가 수정되었습니다. >>");
		} else {
			System.out.println("<< 회원정보 수정에 실패했습니다. >>");
		}
	}

	// 회원삭제
	public static void delMem() {
		System.out.println("삭제할 회원의 번호를 입력해 주세요");
		int num = scan.nextInt();
		int n = daoM.delMem(num);
		if (n == 1) {
			System.out.println("<< 탈퇴되었습니다. >>");
		} else {
			System.out.println("<< 탈퇴에 실패했습니다. >>");
		}
	}

	// 선택회원조회
	public static void search() {
		System.out.println("조회할 회원의 번호를 입력하세요");
		int num = scan.nextInt();
		joinDto dto = daoM.search(num);
		if (dto != null) {
			System.out.println("<< 조회된 회원정보 >>");
			System.out.println("회원번호: " + dto.getNum() + " / 이름: " + dto.getName() + " / 비밀번호: " + dto.getPw()
					+ " / 이메일: " + dto.getEmail() + " / 계좌번호: " + dto.getAccnum() + " / 잔액: " + dto.getAmount() + "원");
			System.out.println("==============================================");
		} else {
			System.out.println("<< 조회할 회원이 없습니다. >>");
		}
	}

	// 전체회원조회
	public static void viewAll() {
		ArrayList<joinDto> list = daoM.viewAll();
		System.out.println("<< 전체회원조회 >>");
		for (int i = 0; i < list.size(); i++) {
			joinDto dto = list.get(i);
			System.out.println("회원번호: " + dto.getNum() + " / 이름: " + dto.getName() + " / 비밀번호: " + dto.getPw()
					+ " / 이메일: " + dto.getEmail() + " / 계좌번호: " + dto.getAccnum() + " / 잔액: " + dto.getAmount() + "원");
		}
		System.out.println(
				"==================================================================================================");
	}

	// 지출내역추가
	public static void addWith() {
		System.out.println("출금 내역을 추가할 회원의 번호를 입력해 주세요.");
		int num = scan.nextInt();
		System.out.println("출금 내용을 입력해 주세요. 예)커피 ");
		String category = scan.next();
		System.out.println("출금 금액을 입력해 주세요.");
		int money = scan.nextInt();
		WithDto dto = new WithDto(num, null, category, money);
		daoW.addWith(dto);
	}

	// 수입내역추가
	public static void addDep() {
		System.out.println("입금 내역을 추가할 회원의 번호를 입력해 주세요.");
		int num = scan.nextInt();
		System.out.println("입금 내용을 입력해 주세요. 예)급여");
		String category = scan.next();
		System.out.println("입금 금액을 입력해 주세요");
		int money = scan.nextInt();
		DepDto dto = new DepDto(num, null, category, money);
		daoD.addDep(dto);
	}

	// 전체지출내역보기
	public static void withAll() {
		System.out.println("전체 출금내역이 궁금한 회원의 번호를 입력해 주세요");
		int num = scan.nextInt();
		ArrayList<WithDto> list = daoW.withAll(num);
		int tot = 0;
		if (list != null) {
			System.out.println("<< 조회된 회원의 전체 출금내역 >>");
			for (int i = 0; i < list.size(); i++) {
				WithDto dto = list.get(i);
				tot = dto.getMoney() + tot;
				System.out.println(
						"날짜: " + dto.getCadate() + " / 내용: " + dto.getCategory() + " / 금액: " + dto.getMoney() + "원");
			}
			System.out.println("총 지출금액: " + tot + "원");
			System.out.println("==============================================");
		} else {
			System.out.println("<< 조회할 지출내역이 없습니다. >>");
			System.out.println("============================");
		}
	}

	// 전체수입내역보기
	public static void depAll() {
		System.out.println("전체 입금내역이 궁금한 회원의 번호를 입력해 주세요");
		int num = scan.nextInt();
		ArrayList<DepDto> list = daoD.depAll(num);
		int tot = 0;
		if (list != null) {
			System.out.println("<< 조회된 회원의 전체 입금내역 >>");
			for (int i = 0; i < list.size(); i++) {
				DepDto dto = list.get(i);
				tot = dto.getMoney() + tot;
				System.out.println(
						"날짜: " + dto.getCadate() + " / 내용: " + dto.getCategory() + " / 금액: " + dto.getMoney() + "원");
			}
			System.out.println("총 수입금액: " + tot + "원");
			System.out.println("==============================================");
		} else {
			System.out.println("<< 조회할 수입내역이 없습니다. >>");
			System.out.println("============================");
		}
	}
}
