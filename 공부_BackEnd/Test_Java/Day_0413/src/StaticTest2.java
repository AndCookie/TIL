class MyStatic1 {
	int data1; // 멤버가 맞음
	static int data2 = 22; // 멤버가 아니고 그저 class 안에 들어와있을 뿐!
	// 클래스 변수임! // 객체 생성하지 않고도 쓸 수 있음
	
	// 생성자
	public MyStatic1(int data1) {
		// 기본 생성자 아님. 외부에서 데이터를 받아서 초기화 해준 것
		this.data1 = data1;
	}
	
	// 정적 메소드 -> 객체 생성하지 않고도 쓸 수 있음
	static void aMethod() {
		System.out.println("이것은 정적 메소드 입니다." + data2);
		// static은 static에 접근 가능 : data2에는 접근할 수 있음.
//		System.out.println("이것은 정적 메소드 입니다." + data1);
		// static은 non-static에 접근 불가능 : data1에는 접근할 수 없음.
	}
}




class YourStatic { // 멤버들이 전부 다 static이므로 객체 생성할 필요 없음!
	static int dataA = 10;
	static int dataB = 20;
	final static double DATA_C = 42.195; // 상수 (naming rule: 전부 대문자이고 콤마로 연결)
	
	static void methodB() {
		System.out.println("a= " + "dataA" + ", b= " + "dataB");
	}
	
	// 모든 것이 static일 때, 아래의 것을 쓰면 자동생성자가 생겨 외부에서 쓰는 일이 없도록 할 수 있음
	private YourStatic() {}
}




public class StaticTest2 {

	public static void main(String[] args) {
		
		// 객체 생성하지 않고도 쓸 수 있음
		System.out.println(MyStatic1.data2); // static은 기울임체로 표현됨
		// out도 System이라는 class의 static한 애구나~
		
		// 객체 생성하지 않고도 쓸 수 있음
		MyStatic1.aMethod();
		
		// 객체 생성을 해야만 쓸 수 있음
		MyStatic1 s = new MyStatic1(15); // data1이 15라는 값으로 초기화
		System.out.println("결과: " + s.data1);
		
		// YourStatic은 객체 생성하지 않고도 쓸 수 있음
//		YoutStatic.methodB();
//		YourStatic ss = new YourStatic();
		// JVM이 기본 생성자를 만들어줬기 때문에 실행 가능했었으나
		// private YourStatic() {} 해주면 실행 불가
	}

}
