package problem.mybatisBank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호

		while (true) {
			System.out.println("================================");
			System.out.println("== 은행 프로그램");
			System.out.println("== 1. 계좌 개설"); 
			System.out.println("== 2. 계좌 입금"); 
			System.out.println("== 3. 계좌 출금");  
			System.out.println("== 4. 고객 조회");
			System.out.println("== 5. 계좌 조회"); 
			System.out.println("== 6. 계좌 해지");
			System.out.println("== 7. 종료"); // EXIT

			while (true) {
				System.out.print("원하는 기능을 선택하세요 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 9) {
					break;
				} else {
					continue;
				}
			}
			if (code == 1) {
				System.out.println("================================");
				System.out.println("신규 계좌를 개설합니다. 값을 입력해주세요.");
				System.out.println("이름, 패스워드, 금액을 쓰세요");
				System.out.print("이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("패스워드 >> ");
				String pw = sc.nextLine();
				bDao.insertBank(bname, pw);
			}
			if (code == 2) {
				System.out.println("================================");
				System.out.println("계좌에 입금합니다. 값을 입력해주세요.");
				System.out.print("계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("입금할 금액 >> ");
				int money = sc.nextInt();
				bDao.updatePlusBank(bno, money);
			}
			if (code == 3) {
				System.out.println("================================");
				System.out.println("계좌에서 출금합니다. 계좌번호와 암호를 입력해주세요.");
				System.out.print("계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("패스워드 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				
				if(bDao.checkUser(bno, pw)) {
					// 체크를 통과한 경우에만 값을 출금하게 작성!!
					int balance = bDao.balanceMoney(bno);
					while(true) {
						
					System.out.println("계좌 잔액" + balance);
					System.out.println("출금할 금액을 입력하세요");
					System.out.print("출금액 >> ");
					int money = sc.nextInt();
					// 잔액 = 출금액 = 0 <== 출금
					// 잔액 > 출금액 = 잔액 - 출금액 <== 출금
					// 잔액 < 출금액 = 잘못입력 <== 경고메시지
					if(balance < money) {
						System.out.println("잔액이 부족합니다. 확인해 주세요");
						continue;
					} else {
						// 출금
						bDao.updateMinusBank(bno, money);
						break;
					}
					}
				} else {
					System.out.println("존재하지 않는 계좌번호이거나 암호가 틀렸습니다.");
				}
			}
			if (code == 4) {
				bDao.selectBank();
			}
			if (code == 5) { // 계좌 조회(1건)
				// 계좌번호, 패스워드
				System.out.println("계좌를 조회합니다. 계좌번호와 암호를 입력해 주세요.");
				System.out.print("계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("패스워드 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				bDao.selectAccount(bno, pw);
			}
						
			if (code == 6) {
				System.out.println("계좌를 해지합니다.");
				System.out.print("계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("패스워드 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				bDao.deleteAccount(bno, pw);
				
			}
			if (code == 7) {
				System.out.println("프로그램을 종료합니다.");
				System.out.print("빠이~");
				System.exit(0);
				
			}
		}
	}

}