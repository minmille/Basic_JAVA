package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
	
	
	public void boardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) VALUES(seq_board.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getTitle());
			pstmt.setString(3, bDto.getContent());
			pstmt.setString(4, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(bDto.getTitle() + "을 등록하였습니다.");
			} else {
				System.out.println("게시글 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void boardUpdate(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " 
					+ "SET title = ?, content = ?, writer = ? "
					+ "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(bDto.getBno() + "을 수정하였습니다.");
			} else {
				System.out.println("게시글 수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void boardDelete() {}
	public void boardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list.clear(); // clear 하지 않으면 ArrayList가 계속 쌓이게 된다.
			while(rs.next()) { // rs.next()는 데이터 베이스의 다음줄에서 실행 대기, 데이터가 있으면 1, 없으면 0을 반환한다.
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate); // bDto 가방에 한줄로 담는다.
				list.add(bDto); // bDto가 ArrayList에 반복하면서 담긴다.
			}
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void boardSearch(String title) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board WHERE title LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate); // bDto 가방에 한줄로 담는다.
				list.add(bDto);
			}
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	}
	}
	public void boardView() {}
	public void boardSort() {}
}
