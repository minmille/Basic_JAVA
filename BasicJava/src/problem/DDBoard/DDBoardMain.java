package problem.DDBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class DDBoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호
		
		while (true) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦ 더블디 게시판");
			bDao.boardSelect(); // 전체 조회(객체지향 장점)
			System.out.println("▦▦ 1. 게시글 등록");
			System.out.println("▦▦ 2. 게시글 수정");
			System.out.println("▦▦ 3. 게시글 삭제");
			System.out.println("▦▦ 4. 게시글 조회");
			System.out.println("▦▦ 5. 게시글 검색"); // 게시글 제목으로만
			System.out.println("▦▦ 6. 게시글 정렬");
			System.out.println("▦▦ 7. 상세 게시글");
			System.out.println("▦▦ 8. 만든이");
			System.out.println("▦▦ 9. 프로그램 종료");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");

			while (true) {
				System.out.print("▦▦ 번호 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("번호를 잘못 입력하셨습니다.");
					System.out.println("1 ~ 9 까지 번호를 입력하세요.");
					continue;
				}
			}
			
			if(code ==1) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("제목, 내용, 작성자를 쓰세요");
				System.out.print("제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("내용 >> ");
				String  content = sc.nextLine();
				System.out.println("작성자 >> ");
				String writer = sc.nextLine();
				BoardDTO bDto = new BoardDTO(title, content, writer);
				bDao.boardInsert(bDto);
			} else if(code == 2) {
				bDao.boardSelect();
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("수정할 게시글 번호를 쓰세요");
				System.out.print("번호 >> ");
				int bno = sc.nextInt();
				BoardDTO bDto = new BoardDTO(bno);
				bDao.boardUpdate(bDto);
						
				
			} else if(code == 3) {
				
			} else if(code == 4) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("게시글 조회");
				bDao.boardSelect();
			} else if(code == 5) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("게시글 제목 검색");
				System.out.print("제목 >>");
				sc.nextLine();
				String title = sc.nextLine();
				bDao.boardSearch(title);
			} else if(code == 6) {
				
			} else if(code == 7) {
				
			} else if(code == 8) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦ Name : DD Board Program");
				System.out.println("▦ Version 1.7");
				System.out.println("▦ Use : Java, Oracle");
				System.out.println("▦ Date : 2019.12.17");
				System.out.println("▦ made by mino");
				System.out.println("▦ minmille@hanmail.net");
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			} else if(code == 9) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦▦ [프로그램 종료] ▦▦");
				System.exit(0);
			}
			
		}
	}
}
