package Polygon;

// class �տ��� static�� ������ �ʴ´�
public class Circle {
	// PRIVATE ���� ����  // ������� = �ν��Ͻ� ����
	private int x;
	private int y;
	private double radius;
	private double area;
	
	// �ڵ� �ڵ��ϼ�
	// alt + s : Generate Getters and Setters : ���� �׸�� private�̶�� �ǹ�
	
	// SETTER : ������ �����͸� �ִ� �޼ҵ�
	// method�� ����� ���� �� ��ȯ�� �ؾ��ϴµ�,
	// void : ��ȯŸ���� ���� Ű����� �޼ҵ忡���� ����
	
	// GETTER : �����͸� ������ �޼ҵ�
	// method�� ����� ���� �� ��ȯ�� �ؾ��ϴµ�,
	// int, double, string, array�� ���·� ��ȯ�Ѵٴ� �ǹ�
	// �ϳ��� �޼ҵ�� ������ �� ���� ���� ���� ����
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		calcArea(); // radius�� �ٲ�� area�� �ٲ�� �ϱ� ���� ��ġ
	}

	public double getArea() {
		return area;
	}

//	public void setArea(double area) {
//		this.area = area;
//	}
	
	private void calcArea() {
		area = 3.14 * radius * radius;
}

	// �߰� ����
	// ���� x��ǥ�� x��ŭ �̵��ϵ��� �ϰ� �ʹٸ� �Ʒ��� ���� ����� public���� �����صθ� ��
	public void moveX(int x) {
		this.x = this.x + x;
	}
	
	
	// OUTPUT
	public void output() { // static�� �츮 ����� �� �� �����Ƿ� �����ؾ�	
		System.out.println("x��ǥ : " + x);
		System.out.println("y��ǥ : " + y);
		System.out.println("������ : " + radius);
		System.out.println("���� : " + area);
	}
	
	
}
