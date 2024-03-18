
public class MethodTest1 {
		// 무조건 main에서 먼저 시작
	public static void main(String[] args) {
		// 미리 지정된 값으로 사칙연산 수행하기
		int result = 0; // 변수 선언
		// main은 jvm이 알아서 호출해주는데
		// add1은 혼자서 실행할 수 없으므로
		// main에서 불러줘야 한다.
		
		System.out.println("프로그램이 시작됨!");
		add1(); // 기울임체 : add1이 static이라는 의미
		// 바로 add1으로 이동했다가 실행 후 괄호가 끝난 즉시 다시 여기로 돌아온다
		// "call해서 add1으로 제어가 넘어갔다"
		
		result = add2();
//		add2();
		// 1단계 : add2() : add2호출
		// 2단계 : = : 대입 (정수가 반환된 것을 대입하지 않으면, 즉 받지 않으면 result는 0으로 출력됨)
		// 정수가 반환된 
		System.out.println("add2()의 결과: " + result);
		
		result = add3(12, 23); // 아규먼트(Argument) = 전달인자
		// 12 = int num1 / 23 = int num2
		// result = num1 + num2 = 12+23 = 35;
		System.out.println("add3()의 결과: " + result);
		
	}
	
	public static void add1() {
		// 메소드명 : add1
		// void : 반환 타입 없음
		// public static void add1() : 메소드 시그니처 : 어떻게 쓸 지 대략 감을 잡을 수 있기 때문
		int num1 = 10;
		int num2 = 20;
		
		int result = num1 + num2;
		System.out.println("덧셈 결과: " + result);
		// return; // 반환할 것이 없기 때문에 return 자체를 생략 가능
	}
	
	public static int add2() {
		// int : 작업 후 무조건 정수형을 반환해야 함
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		// 메소드 안에서 선언된 변수는 지역변수이므로
		// add1지역과 add2지역의 변수명이 같더라도 상관 없다
		return result; // 생략시 오류 발생
	}
	
	public static int add3(int num1, int num2) {
		// int : 작업 후 무조건 정수형을 반환해야 함
		// (int num1, int num2) : 매개변수 = 파라미터
		// 내부에서 데이터를 만드는 것이 아니라
		// 전달 인자로부터 직접  add할 테이터를 전달 받는 것
		int result = num1 + num2;
		return result;
	}
	
}
