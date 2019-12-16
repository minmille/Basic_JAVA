package problem.DDEnter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	Connection conn; // 객체자료형은 자바가 기본적으로 null로 초기화한다.
	PreparedStatement pstmt;
	ArrayList<MemberDTO> list = new ArrayList<>();

	// 1. 아티스트 등록
	public void memInsert(MemberDTO mDTO) {
		try {
			conn = DBManager.getConnection(); // 연결정보가 conn에 들어간다.
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
					+ "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // pstmt에 sql문을 담음
			pstmt.setString(1, mDTO.getAname());
			pstmt.setString(2, mDTO.getMajor());
			pstmt.setString(3, mDTO.getGroupyn());
			pstmt.setString(4, mDTO.getGroupnm());
			pstmt.setInt(5, mDTO.getSal());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(mDTO.getAname() + "을 등록하였습니다.");
			} else {
				System.out.println("아티스트 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	// 2. 아티스트 수정
	public void memUpdate(MemberDTO mDTO) {
		try {
			System.out.println(mDTO.toString());
			conn = DBManager.getConnection(); // 연결정보가 conn에 들어간다.
			String sql = "UPDATE tbl_enter " + "SET aname = ?, " + "major = ?, " + "groupyn = ?, " + "groupnm = ?, "
					+ "sal = ? " + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql); // pstmt에 sql문을 담음
			pstmt.setString(1, mDTO.getAname());
			pstmt.setString(2, mDTO.getMajor());
			pstmt.setString(3, mDTO.getGroupyn());
			pstmt.setString(4, mDTO.getGroupnm());
			pstmt.setInt(5, mDTO.getSal());
			pstmt.setString(6, mDTO.getAno());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(mDTO.getAname() + "을 수정하였습니다.");
			} else {
				System.out.println("아티스트 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	// 3. 아티스트 해지
	public void memDelect(String ano) {
		try {
			// 1.드라이버 로드, 2.DB연결
			conn = DBManager.getConnection();
			// 3.SQL문 작성
			String sql = "DELETE FROM tbl_enter WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano); // 미완성 SQL문 완성 (바인딩 변수 사용)
			// 4. SQL문 실행
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(ano + "와 계약을 해지하였습니다.");
			} else {
				System.out.println("계약해지실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 4. 아티스트 조회
	public void memSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter";
			pstmt = conn.prepareStatement(sql);

			// 4. SQL 실행
			// ResultSet = SELECT문 결과를 닫음
			ResultSet rs = pstmt.executeQuery(); // SELECT 문

			while (rs.next()) { // rs에 첫번째 줄에 대기 (값이 있으면 true를 반환)
				// 반복 후 다음줄로 가고 데이터가 있으면 true 반환
				// 다음 줄에 데이터가 없으면 false를 반환
				// 반복 한번 당 한줄을 읽어온다.
				// DB의 Column과 똑같이 써줘야 한다.
				String ano = rs.getString("ano");
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
			}

			// 전체 출력 향상된 for문 (foreach)
			for (MemberDTO line : list) {
				System.out.println(line.toString()); // toString으로 아래 출력문을 간단하게 만들 수 있다.
				/*
				 * System.out.print(line.getAno() + "\t"); System.out.print(line.getAname() +
				 * "\t"); System.out.print(line.getMajor() + "\t");
				 * System.out.print(line.getGroupyn() + "\t");
				 * System.out.print(line.getGroupnm() + "\t");
				 * System.out.print(line.getRegdate()); System.out.println();
				 */
			}

			// ResultSet은 DB관련객체
			// Java 전용 ArrayList에 ResultSet에 데이터를
			// 옮겨 담는 작업이 필요
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 5. 아티스트 검색
	public void memSearch(String aname) {
		try {
			// 1). 드라이버 등록, 2). connection
			conn = DBManager.getConnection();
			// 3). SQL 작성
			String sql = "SELECT * FROM tbl_enter " + "WHERE aname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + aname + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String ano = rs.getString("ano");
				aname = rs.getString("aname"); // 지역변수에 선언되어 있으므로 객체참조자료형을 쓰지 않는다.
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
			}
			for (MemberDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}