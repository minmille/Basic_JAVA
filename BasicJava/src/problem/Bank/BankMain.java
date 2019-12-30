package problem.Bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호

		while (true) {
			System.out.println("================================");
			System.out.println("== 은행 프로그램");
			System.out.println("== 1. 계좌 개설"); // INSERT
			System.out.println("== 2. 계좌 입금"); // UPDATE
			System.out.println("== 3. 계좌 출금"); // UPDATE 
			System.out.println("== 4. 계좌 조회"); // SELECT
			System.out.println("== 5. 사용자 검색"); // SELECT
			System.out.println("== 6. 종료"); // EXIT

			while (true) {
				System.out.print("원하는 기능을 선택하세요 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("1부터 6까지의 숫자를 입력하세요");
					continue;
				}
			}

	 		if (code == 1) {
				System.out.println("================================");
				System.out.println("이름, 패스워드, 금액을 쓰세요");
				System.out.print("이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("패스워드 >> ");
				String pw = sc.nextLine();
				System.out.print("금액 >> ");
				int money = sc.nextInt();
				BankDTO bDto = new BankDTO(bname, pw, money); 
				System.out.println("check1");
				bDao.bankMake(bDto);
				System.out.println("check0");

	 		}
			if (code == 2) {
				System.out.println("================================");
				System.out.println("입금하려는 계좌의 이름을 입력하세요");
				System.out.print("이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("입금할 금액 >> ");
				int money = sc.nextInt();
				BankDTO bDto = new BankDTO(bname, money);
				bDao.bankInsert(bDto);
			}
			if (code == 3) {

			}
			if (code == 4) {
				System.out.println("================================");
				System.out.println("===이름=== ===가입일시===");
				bDao.bankView();
			}
			if (code == 5) {

			}
			if (code == 6) {
				System.exit(0);
				
			}
		}
		}
	}




