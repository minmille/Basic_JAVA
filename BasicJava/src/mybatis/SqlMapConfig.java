package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// SqlMapConfig는 Builder를 통해서 Factory를 만들어 주는 역할
public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 블럭을 정적 블럭이라고 한다.
	static { // 클래스 로딩시 1회만 실행되는 코드
		String resource = "mybatis/Configuration.xml"; // resource 변수에 값을 담음
		
		try {
			// reader 에는 Configuration.xml 이 담겨 있다.
			Reader reader = Resources.getResourceAsReader(resource); //매개변수가 있는 경로로 가서 한줄씩 읽어서 reader에 담는다.
			
			// reader 값을 담고 있는 공장을 만든다.
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // build pattern(빌드 패턴)-전문가(빌드)한테 대신해달라고 하기 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
