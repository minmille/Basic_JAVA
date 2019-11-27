package shop;

import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		// 사용자에게 값을 입력(회원관련 기능 구현)
		// 1. 회원가입
		// 2. 회원수정
		// 3. 회원탈퇴

		// 객체 생성 (사용자 키보드값을 받기 위한)
		Scanner sc = new Scanner(System.in);

		System.out.println("▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧▧");
		System.out.println("▧ Shooop ver 1.5");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 회원수정 ");
		System.out.println("3. 회원탈퇴 ");
		int num;

		while (true) {
			System.out.print("▧ 번호 >> ");
			// 키보드 정수값을 입력받아 num 변수에 담는 코드
			num = sc.nextInt();

			// 1,2,3 외의 값이 들어온 경우 error 발생
			// 및 다시 번호를 입력받음
			// 1,2,3이 들어온 경우 while()문을 break
			if (num < 1 || num > 3) {
				System.out.println("Error → 1,2,3 의 값을 입력");
				continue;
			} else {
				break;
			}
		}

		// 사용자가 입력한 값은 1,2,3 중 하나
		Member mem = new Member();
		if (num == 1) { // 회원가입
			String id = "미노";
			String pw = "몰라";
			String name = "민호";
			String result = mem.memInsert(id, pw, name); // success가 담겨 있음

			if (result.equals("success")) { // 문자열 동등비교시에는 equals() 사용 (== 사용하면 안됨)
				System.out.println("회원가입 성공! 메인 페이지로 이동합니다.");
			} else {
				System.out.println("회원가입 실패! 에러 메시지 출력");
			}

		} else if (num == 2) { // 회원수정
			mem.memUpdate();
		} else if (num == 3) { // 회원탈퇴
			String id = "미노";
			String pw = "몰라";
			mem.memDelete(id, pw);
		}
	}
}
