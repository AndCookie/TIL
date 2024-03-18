package service;

import vo.Fitness;

public class FitnessServiceImpl implements FitnessService {
	Fitness[] list = new Fitness[MAX];
	int count = 0;
	
	@Override
	public boolean insert(Fitness fitness) {	
		list[count] = fitness;
		++count;		
		return true;
	}

	@Override
	public Fitness selectOne(String id) {
		for (int i=0; i<count; ++i) {
			if (list[i].getId().equals(id)) { // list[i].toString() 생략해도 자동으로 붙여줌
				return list[i]; // 찾은 정보를 반환
			}
		}
		return null;
	}

	@Override
	public boolean update(Fitness fitness) {
		for (int i=0; i<count; ++i) {
			if (list[i].getId().equals(fitness.getId())) {
				list[i].setHeight(fitness.getHeight());
				list[i].setWeight(fitness.getWeight());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		// position을 넣어서 바꾸기
		// 진짜 탈퇴할 건지 재확인하기
		for (int i=0; i<count; ++i) {
			if (list[i].getId().equals(id)) {
				for (int j=i; j<count-1; ++j) { // count-1 : 5번방은 아무것도 없는 null이므로 옮길 것 없음
					list[j] = list[j+1];
				}
				--count;
				return true;
			}
		}	
		return false;
	}

	@Override
	public Fitness[] selectAll() {
		return list;
	}

	@Override
	public int getCount() {
		return count;
	}

}
