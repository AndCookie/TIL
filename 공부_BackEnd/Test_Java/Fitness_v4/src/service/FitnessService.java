/* 
 * 수정 순서
 * Service -> ServiceImpl -> UI -> Fitness -> Test
 */
package service;

import java.util.List;

import vo.Fitness;

public interface FitnessService {
//	public static final int MAX = 100; =============
	// arrayList는 여유 공간이 있으므로 100개 한정할 필요 없음!!
	
	/**
	 * 회원정보객체를 전달받아 Array에 저장
	 * @param fitness
	 * @return 저장 성공하면 true, 실패하면 false
	 */
	public boolean insert(Fitness fitness);
	
	/**
	 * 회원의 PK정보를 전달받아 검색된 회원정보 반환
	 * @param id 회원의 PK
	 * @return 검색된 회원객체, 검색 실패 시 null
	 */
	public Fitness selectOne(String id);
	
	/**
	 * 수정하고자 하는 회원정보를 객체로 받아 수정 실시
	 * @param fitness 수정하고자 하는 회원객체
	 * @return 수정 성공 시 true, 실패 시 false
	 */
	public boolean update(Fitness fitness);
	
	/**
	 * 회원 정보 삭제
	 * @param id 삭제하고자 하는 회원의 ID
	 * @return 삭제 성공 시 true, 실패 시 false
	 */
	public boolean delete(String id);
	
	/**
	 * 전체 회원 정보 조회
	 * @return 모든 회원의 정보가 저장된 배열
	 */
//	public Fitness[] selectAll(); ==================
	public List<Fitness> selectAll();
	
	/**
	 * 전체 회원 수
	 * @return 회원수
	 */
//	public int getCount(); ================
	// size로 알 수 있으므로 삭제!!
}
