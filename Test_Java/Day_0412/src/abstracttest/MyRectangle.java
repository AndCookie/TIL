package abstracttest;

//public class MyRectangle : public을 붙여야 다른 패키지에서도 쓸 수 있음
//class MyRectangle : 현재 패키지에서만 사용 가능하며 다른 패키지에서는 사용 불가 = 디폴트 클래스 = 패키지 클래스
public class MyRectangle extends MyPoint {
	// 멤버변수
	private double width;
	private double height;
	
	// 기본생성자
	public MyRectangle() {
		super(); // 부모의 생성자를 호출 // 생성자의 가장 상단에 와야함 // 생략도 가능
	}
	// 오버로드된 생성자
	public MyRectangle(double width, double height) { // 생성자
		super(); // 부모의 생성자를 호출 // 생성자의 가장 상단에 와야함 // 생략도 가능
		this.width = width;
		this.height = height;
	}
	
	// getter, setter
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;	
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	//오버라이드
	// abstract 클래스를 상속받은 자식들은 무조건 abstract 메소드를 override 해야함
	@Override
	public double area() {
		return height * width;
	}	
	
	// 오버라이드
	@Override
	public String toString() {
		return super.toString() + ", " + "width=" + width
				+ ", height=" + height + ", area=" + area();
		// super.toString() : 부모클래스의 toString을 문자열로 반환
	}

	
}