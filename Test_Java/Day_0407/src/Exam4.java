import java.util.Scanner;
/*
 * [문제4] 소수 판별 및 출력
 * 임의의 정수를 입력받아, 해당 정수가 소수인지 판별하는 코드를 작성하시오
 * 소수의 정의 : 1과 자기자신 외에는 나누어 떨어지지 않는 수
 * 
 * <실행 예시>
 * 정수 입력 : 9
 * 2 3 5 7 끝!
 * 
 */

public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int number;
		
		// Loop
		System.out.println("정수 입력 : ");
		number = keyin.nextInt();
		
		Loop :
		for (int i=2; i<number; ++i) {
			for (int j=2; j<i; ++j) {
				if (i%j == 0) continue Loop; // 소수가 아님
			}
			System.out.print(i + " ");
		}
		System.out.println("끝!");
		keyin.close(); 

	}


}
