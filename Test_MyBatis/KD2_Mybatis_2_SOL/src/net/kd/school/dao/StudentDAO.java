package net.kd.school.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.school.vo.StudentVO;

public class StudentDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * �л� ���
	 * @param vo ����� �л� ����
	 * @return ����� �� ��
	 */
	public int insertStudent(StudentVO vo) {
		SqlSession session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		
		int result = mapper.insertStudent(vo);
		session.commit();
		
		return result;
	}
	
	/**
	 * 1���� �л� ���� ��ȸ
	 * @param stnum ��ȸ�� �л� ��ȣ
	 * @return �л� ����
	 */
	public StudentVO findByNum(String stnum) {
		SqlSession session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);

		StudentVO result = mapper.findByNum(stnum);
		return result;
	}
	
	/**
	 * �л� ���� ����
	 * @param stnum ������ �л� ��ȣ
	 * @return ������ �� �� 
	 */
	public int deleteStudent(String stnum) {
		SqlSession session = factory.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);

		int result = mapper.deleteStudent(stnum);
		session.commit();
		
		return result;
	}
}