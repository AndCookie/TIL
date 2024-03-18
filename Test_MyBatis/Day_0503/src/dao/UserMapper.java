package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.User;

public class UserMapper { // DAO 인터페이스를 implements한 것이 아님!!!!
	// 접속 정보
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insert(User user) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		int result = dao.insertUser(user);
		session.commit();
		
		if (result == 0) return false;
		return true;
		
	}
	
	public User selectOne(String userid) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		User user = dao.selectOne(userid);		
		return user;
	}
	
	public List<User> selectAll() {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		List<User> list = dao.selectAll();
		return list;
	}
	
}
