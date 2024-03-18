package net.kd.school.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.school.vo.StudentVO;

public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * 학생 등록
	 * @param vo 등록할 학생 정보
	 * @return 저장된 행 수
	 */
	public int insertStudent(StudentVO vo) {
		SqlSession session = null;
		session = factory.openSession();
		
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		int result = mapper.insertStudent(vo);
		session.commit();
		
		return result;
	}
	
	/**
	 * 1명의 학생 정보 조회
	 * @param stnum 조회할 학생 번호
	 * @return 학생 정보
	 */
	public StudentVO findByNum(String stnum) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		StudentVO student = mapper.findByNum(stnum);		
		return student;
	}
	
	/**
	 * 학생 정보 삭제
	 * @param stnum 삭제할 학생 번호
	 * @return 삭제된 행 수 
	 */
	public int deleteStudent(String stnum) {
		SqlSession session = null;
		session = factory.openSession();
		
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		int result = mapper.deleteStudent(stnum);
		session.commit();
		
		return result;
	}
}