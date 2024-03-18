package polygon;

public class MyCircle extends MyPoint {
	// 멤버변수
	private double radius;
	
	// 기본생성자 // 메모리에 올리고 0으로 초기화하는 역할
	public MyCircle() {
		super(); // 부모의 생성자를 호출 // 생성자의 가장 상단에 와야함 // 생략도 가능
	}
	// 오버로드된 생성자 // 메모리에 올리고 전달받은 값 double radius으로 초기화하는 역할
	public MyCircle(double radius) {
		super(); // 부모 클래스인 MyPoint부터 생성
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
	
	// 오버라이드
	@Override
	public String toString() {
		return super.toString() + ", " + "radius=" + radius + ", area=" + area();
		// super.toString() : 부모클래스의 toString을 문자열로 반환
	}

	
	
	
}
