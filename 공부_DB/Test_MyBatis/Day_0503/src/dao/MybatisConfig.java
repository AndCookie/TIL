package dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// 세션 정보를 여러 개 갖고 있는 객체

public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// 메모리 올리다가 에러나면 IOException 발생 가능
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		// SqlSessionFactory을 가져다 쓸 수 있도록 하는 메서드 만들기
		return sqlSessionFactory;
	}
	
}
