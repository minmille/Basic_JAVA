package problem.mybatisBoard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import problem.mybatisBank.BankDTO;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	int result;

	public void boardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		try {
			result = sqlSession.insert("insertBoard", map);
			if (result > 0) {
				System.out.println(writer + "님의 게시글이 등록되었습니다.");
			} else {
				System.out.println("게시글 등록이 실패했습니다.");
				System.out.println("다시 등록해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardUpdate(int bno, String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		try {
			result = sqlSession.update("boardUpdate", map);
			if (result > 0) {
				System.out.println(writer + "님의 게시글이 수정되었습니다.");
			} else {
				System.out.println("게시글 수정에 실패하였습니다. 관리자에게 문의해 주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardDelete(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("boardDelete", bno);
			if(result > 0) {
				System.out.println(bno + " 번 게시글을 삭제하였습니다.");
			} else {
				System.out.println("게시글 삭제에 실패했습니다. 관리자에게 문의해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardSelect() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSelect");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardSearch(String keword) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", keword);
		map.put("content", keword);
		try {
			list = sqlSession.selectList("boardSearch", map);
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardSort() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSort");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardView(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			list = sqlSession.selectOne("boardView", bno);
			System.out.println(list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}