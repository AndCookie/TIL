import java.util.Scanner;

public class MethodTest2 {

	public static void main(String[] args) {
		// 미리 a, b의 값을 지정하여 사칙연산 수행하기
//		int a = 15, b=23;
		// 키보드로부터 a, b의 값을 입력받아 사칙연산을 수행하시오.
		int a, b;
		Scanner keyin = new Scanner(System.in);
		System.out.println("정수 2개를 입력하시오 : ");
		a = keyin.nextInt();
		b = keyin.nextInt();
		
		System.out.println("덧셈의 결과: " + add(a,b));
		System.out.println("뺄셈의 결과: " + substract(a,b));
		System.out.println("곱셈의 결과: " + multiply(a,b));
		System.out.println("나눗셈의 결과: " + divide(a,b));
		
		keyin.close();
	}
	// 두 개를 전달 받아서 결과를 반환
	public static int add(int num1, int num2) {
		// 외부 (메소드 밖)에서 데이터를 받고 식을 반환
		return num1 + num2;
		// 15+23 = 38
		// 반환되는 순간 num1, num2는 메모리에서 사라짐
	}
	public static int substract(int num1, int num2) {
		return num1 - num2;
	}
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public static int divide(int num1, int num2) {
		// 소수점을 기대하기 어려운 메소드
		return num1 / num2;
	}



}
