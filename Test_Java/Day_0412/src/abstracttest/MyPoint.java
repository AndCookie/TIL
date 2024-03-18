package abstracttest;
// abstract를 붙인 순간 객체 생성 전혀 안함!!!!!!!!!!!!!
// 안에 본체 생성을 안한 public abstract double area(); 때문에 객체 생성 안되는 것

// 나는 객체 생성하지 않을테니까 자식들아 알아서 해라~
// abstract 클래스를 상속받은 자식들은 무조건 abstract메소드를 override 해야함
public abstract class MyPoint {
	// 멤버변수
	private int x, y;
	
	// 기본생성자 // 메모리에 올리고 0으로 초기화하는 역할
	public MyPoint() {
		super();
	}
	// 오버로드된 생성자 // 메모리에 올리고 전달받은 값 double radius으로 초기화하는 역할
	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	// getter, setter
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
	
	////////////////////////////////////////////////
	public abstract double area();
	// abstract 클래스를 상속받은 자식들은 무조건 abstract메소드를 override 해야함
	///////////////////////////////////////////////
	
	// 오버라이드
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

}
