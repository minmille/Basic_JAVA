package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<BookDTO>();

	// 1. 책 등록
	public void bookInsert(BookDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
					+ "VALUES(seq_book.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bDto.getBname());
			pstmt.setInt(2,bDto.getPrice());
			pstmt.setString(3,bDto.getCompany());
			pstmt.setString(4,bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(bDto.getBname() + "을 등록하였습니다.");
			} else {
				System.out.println("책 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	// 2. 책 정보 수정
	public void bookUpdate() {
	}

	public void bookDelete() {
	}

	// 4. 책 조회
	public void bookSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for (BookDTO line : list) {
				System.out.print(line.getBno() + "\t");
				System.out.print(line.getBname() + "\t");
				System.out.print(line.getPrice() + "\t");
				System.out.print(line.getCompany() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	// 5. 책 검색
	public void bookSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book " 
					+ "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bname + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for(BookDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}

	public void madeBy() {
	}

}
