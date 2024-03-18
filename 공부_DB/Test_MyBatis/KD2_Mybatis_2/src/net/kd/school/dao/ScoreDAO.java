package net.kd.school.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.school.vo.ScoreVO;
import net.kd.school.vo.Total;


public class ScoreDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * 성적 등록
	 * @param vo 등록할 성적 정보
	 * @return 저장된 행 수
	 */
	public int scoreInsert(ScoreVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		int result = mapper.scoreInsert(vo);
		session.commit();
		
		return result;
	}
	
	/**
	 * 전체 성적 보기
	 * @return 모든 학생의 성적 정보
	 */
	public List<Total> scoreList() {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class); // UserDAO를 통해 실제 쿼리문이 있는 userMapper.xml와 연동시키는 역할
		
		List<Total> list = mapper.scoreList();
		return list;
	}
}