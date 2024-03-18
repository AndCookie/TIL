package net.kd.cashbook.dao;

import java.util.List;

import net.kd.cashbook.vo.CashItem;
import net.kd.cashbook.vo.Cashbook;
import net.kd.cashbook.vo.TotalAmount;



/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface CashbookMapper {
	// CashItem 전체 조회
	public List<CashItem> selectCashItem();
	
	// 지출 내역 입력
	public int insertCashbook(Cashbook book);
	
	// 년+월별 지출 내역 확인
	public List<Cashbook> ReadCashbookByDate(String date);
	
	// 내역 삭제
	public int deleteCashbook(int seq);
	
	// 지출 통계 조회
	public List<TotalAmount> statatics(String date);

	
}
