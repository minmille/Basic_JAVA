package problem.mybatisBoard;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;

	public void boardInsert(String title, String content, String writer) {
		try {
			sqlSession = sqlSessionFactory.openSession(true);

			HashMap<String, Object> map = new HashMap<>();
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
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
		try {
			sqlSession = sqlSessionFactory.openSession(true);
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("title", title);
			map.put("content", content);
			map.put("writer", writer);
			result = sqlSession.update("boardUpdate", map);
			if(result >0) {
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

}
