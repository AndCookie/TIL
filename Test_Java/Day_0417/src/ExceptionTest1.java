
public class ExceptionTest1 {

	public static void main(String[] args) {
		try {
			String [] str = {"1", "0", "a"}; // 배열 생성과 동시에 초기화
			
			int num1 = Integer.parseInt(str[0]); // 분자
			int num2 = Integer.parseInt(str[1]); // 분모 : 아직 에러 발생x
			int num3 = Integer.parseInt(str[2]);
			int num4 = Integer.parseInt(str[3]); // 3번방은 존재하지 않음
			
			
			int result1 = num1 / num1;
			System.out.println("연산의 결과: " + result1);
			
			int result2 = num1 / num2;
			System.out.println("연산의 결과: " + result2);
			// Exception in thread "main" : 메인 쓰레스에서 예외 발생
			// java.lang.ArithmeticException : arithmetic이라는 예외 발생
			// by zero : 예외 객체의 이름
			// at ExceptionTest1.main(ExceptionTest1.java:10) : 예외 발생 위치
			
			int result3 = num1 / num3;
			System.out.println("연산의 결과: " + result3);
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "a"
			// at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
			// at java.lang.Integer.parseInt(Integer.java:580)
			// at java.lang.Integer.parseInt(Integer.java:615)
			// at ExceptionTest1.main(ExceptionTest1.java:10)
			// Tracing : 실제 오류 발생 이유는 10째줄 때문인데, 이것이 Integer.java의 **라인에 계속하여 전달되었다는 의미
			
			int result4 = num1 / num4;
			System.out.println("연산의 결과: " + result4);
			// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
			// at ExceptionTest1.main(ExceptionTest1.java:11)

		
		} catch(ArithmeticException e) {
			// 예외를 전달인자로 받기 // 변수명 e
			System.out.println(e.getMessage());
			e.printStackTrace(); // 에러를 계층적으로 tracing 추적하여 보여줌
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
			// 위의 자식들이 못잡아내면, 부모인 exception이 잡아주는 것
			// exception을 맨 위에 쓰게 되면, 아래의 자식코드는 데드 코드가 되어버린다.
		} finally {
			// exception이 발생되더라도 반드시 실행되는 코드!!!!!
			// 메모리를 반환하거나 Scanner close 하는 것 등등
		}

	}

}
