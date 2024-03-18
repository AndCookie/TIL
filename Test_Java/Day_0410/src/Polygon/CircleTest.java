package Polygon;

public class CircleTest {
	// 프로그램을 실행하기 위해서는 main이 반드시 있어야 하므로
	// 테스트용 만들때는 무조건 main이 있어야 함
	public static void main(String[] args) {
		// 메소드를 통해서 우회적으로 접근
		// 클래스를 생성해서 사용한다 = 메모리에 올려서 참조한다
		Circle c = new Circle(); // 생성자 매소드 (Constructor)
		// 여기서 c는 stack 영역에 만들어지는 지역변수
		// 이때 heap 영역에 만들어지는 것은 '객체'
		c.setX(5);
		c.setY(7);
		c.setRadius(2.2);
		// 만약 따로 지정을 해두지 않고 바로 c.output(); 실행시 기본값으로 세팅된 0이 출력됨
		c.output();
		System.out.println();		
		}
}