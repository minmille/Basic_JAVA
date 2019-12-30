package problem.Bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BankDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<BankDTO>();
	BankDTO bDto; // DTO에 데이터베이스의 리스트를 담는 변수
	int result; // 데이터 베이스 실행 결과를 담는 변수
	String com; // 커밋 실행문을 담을 변수

	public void bankMake(BankDTO bDTO) {
		try {
			conn = DBManager.getConnection();
			System.out.println("check2");
			String sql = "INSERT INTO tbl_bank(bno, bname, pw, money) " + 
						 "VALUES(seq_bank.NEXTVAL, ?, ?, ?)";
			System.out.println("check3");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
			pstmt.setInt(3, bDto.getMoney());
			System.out.println("check4");
			int result = pstmt.executeUpdate();
			System.out.println("check5");
			if (result > 0) {
				System.out.println(bDto.getBname() + "를 등록하였습니다.");
				com = "COMMIT";
				pstmt = conn.prepareStatement(com);
				conn.close();
				pstmt.close();
			} else {
				System.out.println("check6");
				System.out.println(bDto.getBname() + "등록에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void bankInsert(BankDTO bDto) {
		try {
			while(true) {
			int addMoney = 0;
			if(bDto.getMoney() > 0) {
				conn = DBManager.getConnection();
				String sql = "SELECT money " + 
							 "FROM  tbl_bank " + 
							 "WHERE bname = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bDto.getBname());
				System.out.println("check1");
					while(rs.next()) {
						System.out.println("check10");
						addMoney = rs.getInt("money");
					}
					System.out.println("check2");
					String sqlAddMoney = "UPDATE tbl_bank " +
							 			 "SET ?" +
							 			 "WHERE bname = ?";
					System.out.println("check3");
					pstmt = conn.prepareStatement(sqlAddMoney);
					pstmt.setInt(1, bDto.getMoney() + addMoney);
					pstmt.setString(2, bDto.getBname());
					System.out.println(bDto.getMoney() + "를 입금하였습니다.");
					System.out.println("계좌의 잔액은 " + bDto.getMoney() + addMoney + "원 입니다.");
			 } else {
				 System.out.println("금액을 다시 입력해 주세요.");
				continue;
			}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

	public void bankUpdate() {

	}

	public void bankView() { // 계좌 조회 (전체 계좌의 사용자와 bno만 보이도록)
		try {
		conn = DBManager.getConnection();
		String sql = "SELECT bname, regdate " +
				 	 "FROM tbl_bank";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		list.clear();
		while(rs.next()) {
			String bname = rs.getString("bname");
			Date regdate = rs.getDate("regdate");
			BankDTO bDto = new BankDTO(bname, regdate);
			list.add(bDto);
		}
		for (BankDTO line : list) {
			System.out.print(line.getBname() + " \t");
			System.out.println(line.getRegdate() + " \t");
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public void bankSearch() {

	}

}
