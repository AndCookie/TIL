/*
 * 만약 Main 빼고 전부 다 만들었다면
 * 부분점수로 12점 부여!
 * 12/20점
 * 
 */
public class Circle extends Point implements Area {
	private double radius;
	
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	@Override
	public double area() {
		return 3.14 * radius * radius; // 3.14 = Math.PI
	}

}
