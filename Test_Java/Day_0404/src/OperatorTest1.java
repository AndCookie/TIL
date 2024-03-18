
public class OperatorTest1 {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/(double)b);
		// 정수 나누기 정수의 결과값은 실수형이 아닌 정수형이어야 하므로
		// int 나누기 double의 결과값은 실수형 (promotion)
		System.out.println(a%b);
		// promotion -> casting
		System.out.println("덧셈의 결과:" + (a+b));
		System.out.println("덧셈의 결과:" + a + b);
		System.out.println("뺄셈의 결과:" + (a-b));
		// System.out.println("덧셈의 결과:" + a - b);
		System.out.println("뺄셈의 결과:" + a * b);
		// 문자열 더하기 double의 결과값은 문자열
		// 더하기와 뺄셈의 우선순위가 동일하다면 결합방향이 중요한데
		// 문자열 빼기 double => 오류 발생
		// 더하기와 곱셈 중 곱셈의 우선순위가 높으므로 연산 오류 발생 x
		
	}

}
