/* 
 * 기존에 ServiceImpl이 하던 일을 DAOImpl로 넘기기
 */
package net.kdigital.fitness.service;

import java.util.List;

import net.kdigital.fitness.dao.FitnessDAO;
import net.kdigital.fitness.dao.FitnessDAOImpl;
import net.kdigital.fitness.vo.Fitness;


public class FitnessServiceImpl implements FitnessService {
	// 데이터를 담는 그릇인 ArrayList는 더이상 필요없다!!
	//	List<Fitness> list = new ArrayList<>();
	
	FitnessDAO dao = new FitnessDAOImpl();
	
	@Override
	public boolean insert(Fitness fitness) {
		boolean result = dao.insert(fitness);
		return result;
	}

	@Override
	public Fitness selectOne(String id) {
		Fitness fitness = dao.selectOne(id);
		return fitness;
	}

	@Override
	public boolean update(Fitness fitness) {
		boolean result = dao.update(fitness);
		return result;
	}

	@Override
	public boolean delete(String id) {
		boolean result = dao.delete(id);
		return result;
	}

	@Override
	public List<Fitness> selectAll() {
		List<Fitness> list = dao.selectAll();
		return list;
	}

}
