package problem.dotorybook;

import java.util.Scanner;

public class DotoryBookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			//1. 화면 출력
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			System.out.println("◎◎도토리 서점 관리 시스템 Ver1.2");
			System.out.println("◎◎1.도서 등록");
			System.out.println("◎◎2.도서 수정");
			System.out.println("◎◎3.도서 삭제");
			System.out.println("◎◎4.도서 조회");
			System.out.println("◎◎5.도서 검색");
			System.out.println("◎◎6.만든이");
			System.out.println("◎◎7.프로그램 종료");
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			
			int code = 0;
			while (true) {
				System.out.print("◎◎번호 >> ");
				code = sc.nextInt();
				
				if(code >= 1 && code <= 7) {
					break;
				} else {
					System.out.println("◎◎1~7까지만 입력하세요");
					continue;
				} 

			}
			BookDAO bDao = new BookDAO();
			if(code == 1) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎책을 등록합니다.");
				System.out.println("◎◎책 이름");
				String bname = sc.nextLine();
				sc.nextLine();
				System.out.print("책 가격");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("출판사");
				//sc.nextLine();
				String company = sc.nextLine();
				System.out.print("저자 ");
				String writer = sc.nextLine();
				BookDTO bDto = new BookDTO(bname, price, company, writer);
				bDao.bookInsert(bDto);
				
			} else if(code == 2) {
				
			} else if(code == 3) {
				
			} else if(code == 4) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎현재 판매중인 도서목록을 출력합니다");
				bDao.bookSelect();
			} else if(code == 5) {
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎도서를 검색합니다.");
				System.out.println("도서이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.bookSearch(bname);
				
			} else if(code == 6) {
				
			} else if(code == 7) {
				
			}
		}
	}
}
