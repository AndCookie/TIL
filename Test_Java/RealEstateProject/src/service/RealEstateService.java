package service;

import java.util.List;

import vo.RealEstate;

public interface RealEstateService {
	// 1. 등록
	public boolean insert(RealEstate realEstate);
	// 상위 클래스로 받아야 매/전/월의 세 가지 타입을 다 받을 수 있음
	// abstract 클래스로 만들기 --> 객체 생성 불가
	
	// 2. 검색 (매매/전세/월세 중에 하나의 타입만 반환)
	public List<RealEstate> selectByType(String Type);
	
	// 3. 수정
	public boolean update(RealEstate realEstate);
	
	// 4. 삭제
	public boolean delete(String address);
	
	
	// 5. 전체 출력
	public List<RealEstate> selectAll ();

	// 6. 주소로 검색
	public RealEstate selectByAddress(String address);
	
}
