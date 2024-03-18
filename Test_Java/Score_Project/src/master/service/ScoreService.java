package master.service;

import master.vo.Student;

public interface ScoreService {
	public static final int MAX = 100; // 최대 학생 수
	public static final int SUBJECT = 3; // 과목 수
	
	public boolean insert(Student student);	// 학생 데이터 배열 추가
	public boolean update(Student student);	// 학생 성적 수정
	public boolean delete(String stdid);	// 학생 정보 삭제
	public Student selectOne(String stdid); // 학생 1명의 정보 조회
	public Student[] selectAll();			// 학생 전체의 정보 조회
	public int getCount();					// 등록된 학생수 조회
	
	// 추가기능
	public double [] scoreAnaly();			// 각 과목 평균을 담은 배열 생성
	// 하나만 전달할 수 있으므로, 3과목의 점수를 모두 전달하기 위해서 실수 배열이 필요함
	// 배열의 크기는 3 // 0번방에는 it의 전체평균, 1번방에는 language의 전체평균, 2번방에는 basic의 전체평균
	
	
}
