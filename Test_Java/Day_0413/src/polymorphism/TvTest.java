package polymorphism;

public class TvTest {

	public static void main(String[] args) {
//		// 기존 방식
//		Tv t = new Tv();
//		t.channelUp();
//		System.out.println(t);
		
//		// 다형성
//		// 업캐스팅
//		Tv t1 = new CaptionTv();
//		System.out.println(t1.getClass());
//		// t1은 부모 것만 사용가능하고 자식 것은 사용불가능...
//		
//		// 다운캐스팅
//		((CaptionTv)(t1)).getText();
//		// 이제 부모, 자식의 것 모두 사용 가능
		// 괄호가 빠진다면 .점 연산자의 우선순위가 높으므로 오류 발생함!
		// (CaptionTv)t1.getText()는 오류~
		
		CaptionTv c = new CaptionTv();
		FourKTv f = new FourKTv();
		
		output(c);
		output(f);
	}

	
	
	// CaptionTv와 FourKTv 모두 Tv의 자식이니까!!!
	// 나눠서 할 필요 없이, Tv t로 한 번에 가능함
//	public static void output(CaptionTv c) {
//		///
//	}
//	// 오버로드
//	public static void output(FourKTv f) {
//		///
//	}
	
	// Tv타입 t는 모든 자식을 참조할 수 있다. (output이 c냐, f냐에 따라 달라짐!!!!)
	public static void output(Tv t) { // 상위 레퍼런스 변수t가 하위 객체(caption과 fourk)를 참조함
//		System.out.println(t instanceof Tv); // TRUE : t가 Tv냐???
//		System.out.println(t instanceof CaptionTv); // TRUE : t가 자식 데이터인 Caption을 가리키고 있냐?
//		System.out.println(t instanceof FourKTv); // FALSE : t가 자식 데이터인 FourK를 가리키고 있냐?
//		// instanceof : 이항연산자로 true/false 반환 (뒤에 클래스명 입력 가능)
		
		if (t instanceof CaptionTv) {
			((CaptionTv)t).channelUp(); // 쓰려는 시점에서는 다운캐스팅해야한다
		} else {
			((FourKTv)t).getResolution();
		}
	}
	// 즉, 하나로 자식 클래스를 모두 쓸 수 있다~~~~~
	
}
