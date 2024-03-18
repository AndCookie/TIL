package master.service;

import master.vo.Student;

public class ScoreServiceImpl implements ScoreService {
	Student[] list = new Student[MAX];
	int count = 0;
	double[] list1 = new double[SUBJECT]; 

	@Override
	public boolean insert(Student student) {
		list[count] = student;
		++count;		
		return true;
	}

	@Override
	public boolean update(Student student) {
		for (int i=0; i<count; ++i) {
			if (list[i].getStdid().equals(student.getStdid())) {
				list[i].setIt(student.getIt());
				list[i].setLanguage(student.getLanguage());
				list[i].setBasic(student.getBasic());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean delete(String stdid) {
		// ��¥ ������ ���� ��Ȯ���ϱ�
		for (int i=0; i<count; ++i) {
			if (list[i].getStdid().equals(stdid)) {
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
	public Student selectOne(String stdid) {
		for (int i=0; i<count; ++i) {
			if (list[i].getStdid().equals(stdid)) { // list[i].toString() �����ص� �ڵ����� �ٿ���
				return list[i]; // ã�� ������ ��ȯ
			}
		}
		return null;
	}

	@Override
	public Student[] selectAll() {
		return list;
	}
	
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public double[] scoreAnaly() {
		for (int i=0; i<count; ++i) {
			list1[0] += list[i].getIt();
			list1[1] += list[i].getLanguage();
			list1[2] += list[i].getBasic();
		}
		return list1;
	}

}
