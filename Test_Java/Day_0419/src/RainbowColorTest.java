
public class RainbowColorTest {

	public static void main(String[] args) {
		RainbowColor rainbow = RainbowColor.주;
		System.out.println(rainbow);
		System.out.println(rainbow.getClass());
		
		String o = RainbowColor.주.getData();
		System.out.println(o);
		System.out.println(o.getClass());
		
		
		RainbowColor rainbow2 = RainbowColor.빨;
		System.out.println(rainbow2);
		System.out.println(rainbow2.getClass());
		
		String r1 = RainbowColor.빨.getString();
		String r2 = RainbowColor.빨.getString2();
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r1.getClass());
		System.out.println(r2.getClass());
		
		
		switch(rainbow2) {
		case 주 : System.out.println("주황색을 선택"); break;
		case 노 : System.out.println("노란색을 선택"); break;
		default:
			break;
		}
		
		
		////////////////////////////////// 배열
		// values() : enum의 모든 item을 배열로 반환하는 메소드
		RainbowColor [] color = RainbowColor.values();
		// enum 안에 values라는 메소드가 있음
		// 내부 데이터를 배열로 반환
		System.out.println("Item의 개수: " + color.length);
		for (RainbowColor c : color) {
			// 콜론 오른쪽 : 컬렉션 // 콜론 왼쪽 : 컬렉션 내 각 데이터의 타입
			System.out.println(c);
		}
		
		for (int i=0; i<color.length; ++i)
			System.out.println(color[i]);
	}

}
