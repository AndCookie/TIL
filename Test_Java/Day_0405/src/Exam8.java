import java.util.Scanner;

/*
 * [문제-8] 합계 구하기
 * 키보드로 0부터 999까지의 정수를 입력 받은 수 각각의 자릿수의 합한 결과를 출력하는 프로그램을 작성하시오.
 * <실행 예시>
 * 0~999까지의 정수 입력 : 456
 * 15
 * 
 * 0~999까지의 정수 입력 : 123
 * 6
 */
public class Exam8 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int input, result=0;
		
		System.out.print("0~999까지의 정수 입력 : ");
		input = keyin.nextInt();
		result = (input/100) + (input%100)/10 + (input%10)/1 ;
		System.out.println(result);
		
		keyin.close();

	}

}
