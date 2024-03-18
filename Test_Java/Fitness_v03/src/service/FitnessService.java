package service;

import vo.Fitness;

public interface FitnessService {
	
	public static final int MAX = 100; // 상수로 만든 것 -> IMPL에다가 상속함
	
	/*
	 * Fitness 회원 정보 객체를 전달받아 Array배열에 저장
	 * @param fitness
	 * @return boolean : 저장 성공하면 true, 실패하면 false
	 */
	public boolean insert(Fitness fitness);
	// thorws Exception : 처음부터 Exception을 처리하도록 하기!!
	
	/*
	 * Primary Key인 id를 전달받아 회원 정보 Fitness를 반환
	 * @param id : 회원의 PK
	 * @return fitness : 검색된 회원 객체, 검색 실패시 null 반환
	 */
	public Fitness selectOne(String id);
	
	/*
	 * 수정하고자 하는 회원정보를 객체로 받아 수정 실시
	 * @param fitness : 수정하고자 하는 회원 객체
	 * @return boolean :수정 성공시 true, 실패시 false
	 */
	public boolean update(Fitness fitness);
	
	/*
	 * 회원 정보 삭제
	 * 삭제하고자 하는 회원정보를 객체로 받아 회원정보 삭제 실시
	 * @param id : 삭제하고자 하는 회원의 ID
	 * @return boolean : 삭제 성공시 true, 실패시 false
	 * 
	 */
	public boolean delete(String id);
	
	/*
	 * 전체 회원 정보 조회
	 * @param
	 * @return : fitness타입인 모든 회원 정보들의 배열 반환
	 */
	public Fitness[] selectAll();
	
	
	// 전체 회원수를 알기 위한 메소드
	public int getCount();
	
	
}
