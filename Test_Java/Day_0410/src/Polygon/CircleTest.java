package Polygon;

public class CircleTest {
	// ���α׷��� �����ϱ� ���ؼ��� main�� �ݵ�� �־�� �ϹǷ�
	// �׽�Ʈ�� ���鶧�� ������ main�� �־�� ��
	public static void main(String[] args) {
		// �޼ҵ带 ���ؼ� ��ȸ������ ����
		// Ŭ������ �����ؼ� ����Ѵ� = �޸𸮿� �÷��� �����Ѵ�
		Circle c = new Circle(); // ������ �żҵ� (Constructor)
		// ���⼭ c�� stack ������ ��������� ��������
		// �̶� heap ������ ��������� ���� '��ü'
		c.setX(5);
		c.setY(7);
		c.setRadius(2.2);
		// ���� ���� ������ �ص��� �ʰ� �ٷ� c.output(); ����� �⺻������ ���õ� 0�� ��µ�
		c.output();
		System.out.println();		
		}
}