/* 
 * 수정 순서
 * Service -> ServiceImpl -> UI -> Fitness -> Test
 */
package service;

import java.util.ArrayList;
import java.util.List;

import vo.Fitness;

public class FitnessServiceImpl implements FitnessService {
//	Fitness[] list = new Fitness[MAX]; ===========
//	int count = 0; ==================
	List<Fitness> list = new ArrayList<>();
	
	@Override
	public boolean insert(Fitness fitness) {
//		list[count] = fitness;
//		++count;
//		return true;
		
//		boolean bool = list.add(fitness);
//		return bool;
		return list.add(fitness);
	}

	@Override
	public Fitness selectOne(String id) {
//		for(int i=0; i<count; ++i) {
//			 if(list[i].getId().equals(id)) {
//				 return list[i];
//			 }
//		}
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId().equals(id)) {
				// list.get(i) : Fitness 전체를 가져오기
				// getId() : 그 중 id만 가져오기
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean update(Fitness fitness) {
//		for(int i=0; i<count; ++i) {
//			if(list[i].getId().equals(fitness.getId())) {
//				list[i].setWeight(fitness.getWeight());
//				list[i].setHeight(fitness.getHeight());
//				return true;
//			}
//		}
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId().equals(fitness.getId())) {
				list.get(i).setWeight(fitness.getWeight());
				list.get(i).setHeight(fitness.getHeight());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
//		for(int i=0; i<count; ++i) {
//			if(list[i].getId().equals(id)) {
//				for(int j=i; j<count-1; ++j) {
//					list[j] = list[j+1];
//				}
//				--count;
//				return true;
//			}
//		}
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getId().equals(id)) {
//				if (list.remove(i)!=null) // remove는 삭제된 객체를 리턴하기 때문
//					return true;
				list.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
//	public Fitness[] selectAll() {
	public List<Fitness> selectAll() {
		return list;
	}

//	@Override
//	public int getCount() {
//		return count;
//	}

}
