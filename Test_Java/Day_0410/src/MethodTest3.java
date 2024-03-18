
public class MethodTest3 {
	// static 메소드는 non-static에 접근 불가!
	// 반대로 non-static 메소드는 static에 접근 가능
	// static끼리, non-static끼리만 호출 가능
	// static은 미리 메모리에 올라와있지만, unstatic은 메모리에 올라오지 못했기 때문
	// 따라서 unstatic을 사용하는 이유는 메모리 절약
	public static void main(String[] args) {
		methodA();
//		methodB();
//		methodC();
		// 메소드 CALL 불가하므로 에러 발생
		// => 생성한 후에(메모리에 로딩한 후에)나 사용이 가능해짐
	}
	// 클래스나 메소드를 재사용하기 위해 밖에다가 새로운 메소드는 만드는 것
	
	public static void methodA() {
		System.out.println("static 메소드(methodA)입니다.");
//		methodC();
	}
	
	public void methodB() {
		System.out.println("non-static 메소드(methodB)입니다.");
		methodC(); // non-static끼리 호출 가능
		methodA(); // methodA는 이미 호출되어있으므로 호출 가능
	}
	
	public void methodC() {
		System.out.println("non-static 메소드(methodC)입니다.");
	}

}
