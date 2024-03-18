
public class ExceptionTest3 {

	// -1을 식을 수행하지 않는다는 일종의 시그널로 사용한 경우 =========
//	public static void main(String[] args) {
//		int result = divide(20, -10);
//		if (result == -1) {
//			System.out.println("오류 : 음수 처리 불가");
//			return;
//
//		} 
//		System.out.println("답 : " + result);
//	}
//	
//	public static int divide(int a, int b) {
//		if (b<=0) return -1;
//		return a/b;
//		// 정상 처리로 보고 int로 반환
//	}
//}	

	
	
	
	// try-exception ======== 분모가 음수이거나 0이면 익셉션으로 처리 ==========
//	public static void main(String[] args) {
//		int result = 0; // try 밖에서 result를 선언해줘야 지역변수가 아닌 전역변수로 사용 가능
//		try {
//			result = divide(20, -10);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} 
//		System.out.println("답 : " + result);
//	}
//		
//	public static int divide(int a, int b) throws Exception {
//		if (b<=0) {
//			throw new Exception("음수 처리 불가");
//			// new : 객체 생성
//			// throw : 메소드를 호출했던 쪽으로 exception을 던지기 (return과 유사)
//		}
//		return a/b;
//		// 비정상 처리로 보고 호출했던 쪽인 int result = divide(20, 10);로 돌아감
//	}
//}

	
	
	// try-exception ======== 두 값을 더했을 때 20보다 크면 익셉션으로 처리 ==========
	// 참고 : 익셉션이 터지면 더이상 아래의 코드를 진행하지 않고 끝내버림
	public static void main(String[] args) throws Exception {
		// 예외 전가 : 본인이 해결하지 않고 예외를 던져버리는 것!!
		int result = 0;
		add(10, 20);
		System.out.println(result);
	}	
	
	
	public static int add(int a, int b) throws Exception {
		int result = a+b;
		
		if (result>=20) {
			throw new Exception("합이 20보다 크면 안됨!");
			// new : 객체 생성
			// throw : 메소드를 호출했던 쪽으로 exception을 던지기 (return과 유사)
		}
		return result;
		// 비정상 처리로 보고 호출했던 쪽인 int result = divide(20, 10);로 돌아감
	}
	// 익셉션을 처리했다고 보기는 어렵지만.. 우리가 만든 익셉션 구문이 포함되어 있다
	// "합이 20보다 크면 안됨!"

}
