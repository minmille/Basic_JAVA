package problem.mybatisbank;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	// MyBatis 세팅값 호출
	// Session을 생성하는 Factory를 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession(); // SqlMapConfig에서 만든 공장을 가지고 옴

	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;

	List<BankDTO> list2;
	int result;

	// 계좌 개설
	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true); // true가 들어가면 오토 커밋을 한다.
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto); // 컴마 뒤에는 값을 하나밖에 담지 못하므로 가방에 담아서 넣는다.
			sqlSession.commit();
			if (result > 0) {
				System.out.println(bname + "님의 신규 계좌 개설하였습니다.");
			} else {
				System.out.println(bname + "계좌 개설에 실패하였습니다. 관리자에게 문의해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePlusBank(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true); // true가 들어가면 오토 커밋을 한다.
		try {
			BankDTO bDto = new BankDTO(bno, money);
			result = sqlSession.insert("updatePlusBank", bDto); // 컴마 뒤에는 값을 하나밖에 담지 못하므로 가방에 담아서 넣는다.
			if (result > 0) {
				System.out.println(bno + "님의 계좌에 " + money + "원을 입금하였습니다.");
				
				/*
				* list2 = sqlSession.selectList("accountMoneyBank");
				* for (BankDTO line : list2) {
				* 	System.out.println(line.toString());
				*}
				*/
			} else {
				System.out.println(bno + "계좌 입금에 실패하였습니다. 관리자에게 문의해 주세요.");
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public void selectBank() {
		sqlSession = sqlSessionFactory.openSession(); // sqlSession을 하나 만듦

		try {
			list2 = sqlSession.selectList("selBank");
			// selectList는 결과가 여러줄이거나 한 줄인 경우 모두 사용 가능하나,
			// selectOne은 반드시 결과가 한 건(한줄) 인 경우에만 사용
			// insert, update, delete는 그대로 사용 가능

			for (BankDTO line : list2) {
				System.out.println(line.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void selectAccout(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto); // 결과는 1건이므로 바로 담는다.

			if (bDto == null) {
				System.out.println("존재하지 않는 계좌번호이거나 암호가 틀렸습니다.");
				return;
			} else {
				System.out.println(bno + "계좌의 총 금액은" + bDto.getMoney() + "입니다.");
				// System.out.println(bDto.toString());
			}
			// SelectOne => DTO
			// SelectList => List or DTO

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
