package arraytest;

public class StudentTest {

	public static void main(String[] args) {
		// �迭 ����
		int[] iary = new int[10]; // ������ ������ �迭 // 0~9�� �� 10���� �� ����
		String[] sary = new String[10]; // ���ڿ��� ������ �迭
		iary[0] =15;
		sary[0] = "���ѹα�";
		// iary�� sary�� �ٷ� ���� ����������,
		// stdary�� �ݵ�� �л� ������ ������ �Ŀ� �迭�� ���� �� �ִ�
		
		// ==��ü �迭==
		int count=0;
		Student[] stdary = new Student[10]; //�л�(���� ���� Ÿ��)���� ������ �迭
		stdary[count] = new Student("1", "ȫ�浿", 24); // �й�(Primary Key): �ߺ� �Ұ� & �̸��� ����: �ߺ� ����
		++count; // stdary.length �� ���� ������ �˷�������, �濡 �ִ� �������� ������ �˷����� ����

		stdary[count] = new Student("2", "ȫ���", 24);
		count++;
		
		stdary[count] = new Student("2", "����ġ", 24);
		count++;
		
	}

}
