package polygon;

public class MyCircle extends MyPoint {
	// �������
	private double radius;
	
	// �⺻������ // �޸𸮿� �ø��� 0���� �ʱ�ȭ�ϴ� ����
	public MyCircle() {
		super(); // �θ��� �����ڸ� ȣ�� // �������� ���� ��ܿ� �;��� // ������ ����
	}
	// �����ε�� ������ // �޸𸮿� �ø��� ���޹��� �� double radius���� �ʱ�ȭ�ϴ� ����
	public MyCircle(double radius) {
		super(); // �θ� Ŭ������ MyPoint���� ����
		this.radius = radius;
	}
	
	// getter, setter
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return 3.14 * radius * radius;
	}
	
	// �������̵�
	@Override
	public String toString() {
		return super.toString() + ", " + "radius=" + radius + ", area=" + area();
		// super.toString() : �θ�Ŭ������ toString�� ���ڿ��� ��ȯ
	}

	
	
	
}
