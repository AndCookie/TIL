package polygon;


public class PolygonTest {

	public static void main(String[] args) {
		MyCircle c = new MyCircle(5);
		c.setX(1);
		c.setY(1);
		System.out.println(c); // 해쉬주소 출력 : 해킹 위험이 있으므로 진짜 주소는 알고리즘으로 가리는 것
//		// 해시주소 출력 성공시 -> 메모리에 올라왔음을 확인 가능
//		System.out.println(p.toString()); // 객체가 오면 자동으로 toString을 붙여주므로 주소 결과값은 동일
//		// 부모 클래스에서 toString을 override하면 주소값이 아닌 실제값 출력 가능
	
		MyRectangle r = new MyRectangle(2,5);
		r.setX(4);
		r.setY(10);
		System.out.println(r);
	}

}
