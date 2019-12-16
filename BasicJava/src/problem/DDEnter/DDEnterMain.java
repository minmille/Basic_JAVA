package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {
	public static void main(String[] args) {
		while (true) {
			// 1. 화면에 출력하는 부분
			Scanner sc = new Scanner(System.in);
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ ");
			System.out.println("▒▒▒▒ 더블디 엔터 관리 시스템 ▒▒ ");
			System.out.println("▒▒▒▒ 1. 아티스트 등록합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒ 2. 아티스트 수정합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒ 3. 아티스트 해지합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒ 4. 아티스트 조회합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒ 5. 아티스트 검색합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒ 6. 프로그램 종료합니다 ▒▒▒ ");
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ ");

			int code = 0;
			// 2.사용자가 실행할 프로그램을 입력받는 부분
			while (true) {
				System.out.print("번호를 입력하세요 >> ");
				code = sc.nextInt();
				// 사용자가 1-6까지 입력하기 전까지 계속 번호를 입력하게 되는 반복문, 경고메세지 출력
				if (1 > code || code > 6) {
					System.out.println("번호를 잘못입력하였습니다. 다시 입력해주세요");
					continue;
				} else {
					break;
				}
			}
			MemberDAO mDao = new MemberDAO(); // 객체생성함
			// 3. 사용자가 입력한 값이 1-6인 경우
			if (code == 1) { // 아티스트 추가
				System.out.println("아티스트를 추가합니다.");
				System.out.println("아티스트번호, 이름, 분야, 그룹유무, 그룹이름, 연봉을 차례대로 적어주세요");
				System.out.print("이름 >> ");
				sc.nextLine();
				String aname = sc.nextLine();
				System.out.print("분야 >> ");
				String major = sc.nextLine();
				System.out.print("그룹유무(y/n) >> ");
				String groupyn = sc.nextLine();
				System.out.print("그룹이름 >> ");
				String groupnm = sc.nextLine();
				System.out.print("연봉 >> ");
				int sal = sc.nextInt();
				MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal);
				mDao.memInsert(mDto);
			} else if (code == 2) { // 아티스트 수정
				System.out.println("아티스트를 수정합니다.");
				System.out.print("아티스트번호 >> ");
				sc.nextLine();
				String ano = sc.nextLine();
				System.out.print("이름 >> ");
				String aname = sc.nextLine();
				System.out.print("분야 >> ");
				String major = sc.nextLine();
				System.out.print("그룹유무(y/n) >> ");
				String groupyn = sc.nextLine();
				System.out.print("그룹이름 >> ");
				String groupnm = sc.nextLine();
				System.out.print("연봉 >> ");
				int sal = sc.nextInt();
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);
				mDao.memUpdate(mDto);
			} else if (code == 3) { // 아티스트 삭제
				System.out.println("아티스트를 삭제합니다.");
				System.out.println("번호입력 >> ");
				sc.nextLine();
				String ano = sc.nextLine();
				mDao.memDelect(ano);
			} else if (code == 4) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("회사에 소속된 아티스트를 조회");
				mDao.memSelect();
			} else if (code == 5) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("검색할 아티스트의 이름을 입력하세요");
				System.out.print("이름 >>");
				sc.nextLine();
				String aname = sc.nextLine();
				mDao.memSearch(aname);
			} else if (code == 6) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
		}
	}
}
