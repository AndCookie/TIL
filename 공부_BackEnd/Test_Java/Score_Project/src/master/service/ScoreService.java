package master.service;

import master.vo.Student;

public interface ScoreService {
	public static final int MAX = 100; // �ִ� �л� ��
	public static final int SUBJECT = 3; // ���� ��
	
	public boolean insert(Student student);	// �л� ������ �迭 �߰�
	public boolean update(Student student);	// �л� ���� ����
	public boolean delete(String stdid);	// �л� ���� ����
	public Student selectOne(String stdid); // �л� 1���� ���� ��ȸ
	public Student[] selectAll();			// �л� ��ü�� ���� ��ȸ
	public int getCount();					// ��ϵ� �л��� ��ȸ
	
	// �߰����
	public double [] scoreAnaly();			// �� ���� ����� ���� �迭 ����
	// �ϳ��� ������ �� �����Ƿ�, 3������ ������ ��� �����ϱ� ���ؼ� �Ǽ� �迭�� �ʿ���
	// �迭�� ũ��� 3 // 0���濡�� it�� ��ü���, 1���濡�� language�� ��ü���, 2���濡�� basic�� ��ü���
	
	
}
