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
			if (list[i].getId().equals(id)) { // list[i].toString() �����ص� �ڵ����� �ٿ���
				return list[i]; // ã�� ������ ��ȯ
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
		// position�� �־ �ٲٱ�
		// ��¥ Ż���� ���� ��Ȯ���ϱ�
		for (int i=0; i<count; ++i) {
			if (list[i].getId().equals(id)) {
				for (int j=i; j<count-1; ++j) { // count-1 : 5������ �ƹ��͵� ���� null�̹Ƿ� �ű� �� ����
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
