package Polygon;

// class 앞에는 static을 붙이지 않는다
public class Circle {
	// PRIVATE 변수 선언  // 멤버변수 = 인스턴스 변수
	private int x;
	private int y;
	private double radius;
	private double area;
	
	// 코드 자동완성
	// alt + s : Generate Getters and Setters : 빨간 네모는 private이라는 의미
	
	// SETTER : 정보에 데이터를 넣는 메소드
	// method는 기능을 수행 후 반환을 해야하는데,
	// void : 반환타입이 없는 키워드로 메소드에서만 사용됨
	
	// GETTER : 데이터를 꺼내는 메소드
	// method는 기능을 수행 후 반환을 해야하는데,
	// int, double, string, array의 형태로 반환한다는 의미
	// 하나의 메소드는 오로지 한 개의 값만 리턴 가능
	
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
		calcArea(); // radius가 바뀌면 area도 바뀌도록 하기 위한 장치
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

	// 추가 설명
	// 만약 x좌표를 x만큼 이동하도록 하고 싶다면 아래와 같이 만들되 public으로 설정해두면 됨
	public void moveX(int x) {
		this.x = this.x + x;
	}
	
	
	// OUTPUT
	public void output() { // static은 우리 멤버가 될 수 없으므로 삭제해야	
		System.out.println("x좌표 : " + x);
		System.out.println("y좌표 : " + y);
		System.out.println("반지름 : " + radius);
		System.out.println("면적 : " + area);
	}
	
	
}
