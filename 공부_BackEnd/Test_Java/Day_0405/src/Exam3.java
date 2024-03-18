import java.util.Scanner;

/* [문제3] 삼항연산자 사용
 * 정수를 입력받아 홀수인지 짝수인지 출력하시오
 * int value;
 * Scanner keyin;
 * String result; // 문자열("홀수", "짝수")을 담을 변수
 * <실행 예시>
 * 정수 입력 : _
 * _는 홀수
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		int value = 0;
		String result;
		
		System.out.print("정수 입력 : ");
		value = keyin.nextInt();
		result = (value%2==0) ? "짝수" : "홀수";
		System.out.println(value + "는 " + result);
		
		keyin.close();
	}

}
