package net.kd.cashbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.cashbook.vo.CashItem;
import net.kd.cashbook.vo.Cashbook;
import net.kd.cashbook.vo.TotalAmount;



public class CashbookDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// CashItem 전체 조회
	public List<CashItem> selectCashItem() {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		CashbookMapper mapper = session.getMapper(CashbookMapper.class);
		
		List<CashItem> list = mapper.selectCashItem();
		return list;
	}
	
	// 지출 내역 입력
	public int insertCashbook(Cashbook book) {
		SqlSession session = null;
		session = factory.openSession();
		
		CashbookMapper mapper = session.getMapper(CashbookMapper.class);
		int result = mapper.insertCashbook(book);
		session.commit();
		
		return result;
	}
	
	// 년+월별 지출 내역 확인
	public List<Cashbook> ReadCashbookByDate(String date) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		CashbookMapper mapper = session.getMapper(CashbookMapper.class);
		
		List<Cashbook> list = mapper.ReadCashbookByDate(date);
		return list;
	}
	
	// 내역 삭제
	public int deleteCashbook(int seq) {
		SqlSession session = null;
		session = factory.openSession();
		
		CashbookMapper mapper = session.getMapper(CashbookMapper.class);
		int result = mapper.deleteCashbook(seq);
		session.commit();
		
		return result;
	}
	
	// 지출 통계 조회
	public List<TotalAmount> statatics(String date) {
		SqlSession session = null; // SqlSession : SqlSessionFactory에서 하나만 얻어온 것
		session = factory.openSession();
		CashbookMapper mapper = session.getMapper(CashbookMapper.class);
		
		List<TotalAmount> list = mapper.statatics(date);
		return list;
	}
}
