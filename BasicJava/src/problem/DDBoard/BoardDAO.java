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
	BoardDTO bDto;
	int result; // return의 전역변수 선언
	
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
				System.out.println("게시글 " + bDto.getBno() + " 번을 수정하였습니다.");
			} else {
				System.out.println("게시글 수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void boardDelete(int selectNum) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board " +
						 "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public void boardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
						 + "ORDER BY bno DESC"; // DESC로 bno를 역순으로 정렬
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
	public void boardSearch(String keyword) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " +
						 "FROM tbl_board " +
						 "WHERE title LIKE ? OR " +
						 "content LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery(); // rs에 데이터베이스의 결과 리스트가 담긴다
			
			list.clear();
			while(rs.next()) { // rs.next()는 커서가 다음줄로 
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate); // bDto 가방에 한줄로 담는다.
				list.add(bDto); // bDto를 리스트에 추가
			}
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("\"" + keyword + "\"로 검색한 결과 총 " + list.size() + " 건이 검색되었습니다.");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	}
	}

	public void boardView(int bno) {
		// 상세게시글 조회수 +1 증가
		int result = viewCntPlus(bno);
		if(!(result > 0)) { // result가 0보다 크지 않은 경우
			System.out.println("▦▦ 조회수 증가 실패, 관리자에게 문의하세요");
			return; // 메서드 종결의 의미
		}
		// 상세 게시글 출력
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + 
						 "FROM tbl_board " + 
						 "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno); // bno 는 PK이므로 결과는 1건
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate); // bDto 가방에 한줄로 담는다.
				// 결과는 1건이므로 List에 담을 필요 없음
			}
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦ 게시글 번호 " + bno + " ▦▦ ");  
			System.out.println("▦▦ 작성자 " + bDto.getWriter() + " ▦▦ ");
			System.out.println("▦▦ 조회수 " + bDto.getViewcnt() + " ▦▦ ");
			System.out.println("▦▦ 제목 " + bDto.getTitle() + " ▦▦ ");
			System.out.println("▦▦ 내용 " + bDto.getContent() + " ▦▦ ");
			System.out.println("▦▦ 조회수 " + bDto.getViewcnt() + " ▦▦ ");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void boardSort() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + 
						 "ORDER BY viewcnt DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			
			list.clear();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
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
	public int viewCntPlus(int bno) { // 상세 게시글 조회수 업데이트 메서드
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + 
						 "SET viewcnt = viewcnt + 1 " + 
						 "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
}