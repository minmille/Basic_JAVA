package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// 원시시대 방식
public class JdbcEx01 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "java";
		String password = "1234";
		
		// Database 문제가 있을 수 있으니 예외 처리를 해준다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속성공!! 추카추카");
			
			// createStatement() 방식은 값을 하드코딩 해야함 , 구석기(원시시대) 방식
			// 그래서  PreparedStatement 방식을 사용한다.
			Statement st = conn.createStatement(); 
			String sql = "INSERT INTO tbl_study VALUES('5', '미경', 24)"; // Database에 값 등록 , 값을 일일이 등록해야 함
			
			int result = st.executeUpdate(sql);
			if(result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외가 발생했을 때 예외 내용을 알려준다.
			//System.out.println("고장났어요 죄송합니다.");
		} finally {
			
		}
	}
}
