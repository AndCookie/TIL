package net.kd.school.dao;


import java.util.List;

import net.kd.school.vo.ScoreVO;
import net.kd.school.vo.StudentVO;
import net.kd.school.vo.Total;


//학생정보 처리
public interface ScoreMapper {
	//학생 등록
	public int insertStudent(StudentVO vo);
	
	//성적 등록
	public int scoreInsert(ScoreVO vo);
	
	//전체 학생 목록
	public List<StudentVO> selectAll();
	
	//1명의 학생 정보 조회
	public StudentVO findByNum(String stnum);
	
	//학생 정보 삭제
	public int deleteStudent(String stnum);
	

	//전체 성적 읽기
	public List<Total> scoreList();
}
