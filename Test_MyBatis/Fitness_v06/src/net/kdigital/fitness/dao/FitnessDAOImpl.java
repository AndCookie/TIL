package net.kdigital.fitness.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.fitness.vo.Fitness;

public class FitnessDAOImpl implements FitnessDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	@Override
	public boolean insert(Fitness fitness) {
		SqlSession session = null;
		session = factory.openSession();
		
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		boolean result = mapper.insert(fitness);
		session.commit();
		
		return result;
	}

	@Override
	public Fitness selectOne(String id) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		Fitness fitness = mapper.selectOne(id);		
		return fitness;
	}

	@Override
	public boolean update(Fitness fitness) {
		SqlSession session = null;
		session = factory.openSession();
		
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		boolean result = mapper.update(fitness);
		session.commit();
		
		return result;
	}

	@Override
	public boolean delete(String id) {
		SqlSession session = null;
		session = factory.openSession();
		
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		boolean result = mapper.delete(id);
		session.commit();
		
		return result;
	}

	@Override
	public List<Fitness> selectAll() {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		List<Fitness> list = mapper.selectAll();
		return list;
	}
	

}
