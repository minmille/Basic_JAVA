package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();

		

		try { // try절은 예외가 발생할 수 있는 부분
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클을 사용하기 위해 명시
			Connection conn = DBManager.getConnection();
			// conn에 연결 상태를 저장
			
			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)"; // sql문을 sql 변수에 담음
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);

			int result = pstmt.executeUpdate(); // pstmt에 담겨있는 sql 값을 가지고 자바가 데이터베이스에 명령하러 간다.
			// DB가 성공하면 1 값을 리턴 실패하면 0을 리턴
			if (result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}

		} catch (Exception e) {
		} finally {
			
		}
	}
}
