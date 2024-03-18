package net.kdigital.test5.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.test5.domain.Cashbook;

@Mapper
public interface CashbookMapper {

	// 가계부 내역 저장
	public int insertCash(Cashbook cashbook);

	// 특정 사용자의 가계부 목록 조회
	public List<Cashbook> selectAll(String id);
	
	public Map<String, Integer> statistics(String id);

}
