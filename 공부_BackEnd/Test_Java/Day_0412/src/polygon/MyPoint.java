package polygon;

//모든 클래스는 생성자가 있어야합니다. 
public class MyPoint {
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
	
	// 오버라이드
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

}
