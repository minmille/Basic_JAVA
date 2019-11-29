package chapter05;

import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. view단(화면단)
		System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
		System.out.println("▩ == LOGIN SYSTEM ==");
		System.out.print("▩ id >>");
		String id = sc.nextLine();
		System.out.print("▩ pw >>");
		String pw = sc.nextLine();

		// System.out.println(id + ", " + pw);

		// 2. 로그인 기능을 구현(비즈니스 로직)
		// id, pw -> 데이터베이스에서 사용자가 입력한 id, pw와 같은 유저가 있는지 확인 => yes or no
		// -> yes : 환영합니다 회원님~
		// -> no : id or pw 가 틀렸습니다.

		// 로그인 시 회원판별 기능을 사용하기 위한 객체 생성
		MemberDAO mDao = new MemberDAO();
		MemberDTO mDto = new MemberDTO(id, pw);
		int result = mDao.loginCheck(mDto);

		if (result == 1) {
			System.out.println("재방문을 환영합니다.!!");
		} else {
			System.out.println("id 또는 pw가 틀렸습니다.!!");
		}
	}
}
