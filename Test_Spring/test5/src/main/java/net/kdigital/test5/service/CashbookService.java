package net.kdigital.test5.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.test5.domain.Cashbook;
import net.kdigital.test5.mapper.CashbookMapper;

@Service
@Slf4j
public class CashbookService {

	@Autowired
	CashbookMapper mapper;
	
	public int insertCash(Cashbook cashbook) {
		log.info("{}", cashbook.toString());
		int result = mapper.insertCash(cashbook);
		return result;
	}

	public List<Cashbook> selectAll(String id) {
		List<Cashbook> list = mapper.selectAll(id);
		return list;
	}
	
	public Map<String, Integer> statistics(String id) {
		Map<String, Integer> map = mapper.statistics(id);
		return map;
	}

}
