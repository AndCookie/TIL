import java.util.Scanner;
/*
 * [문제6] 소수 판별
 * 임의의 정수를 입력받아, 해당 정수가 소수인지 판별하는 코드를 작성하시오
 * 소수의 정의 : 1과 자기자신 외에는 나누어 떨어지지 않는 수
 * 
 * <실행 예시>
 * 입력 : 3
 * 3은 소수
 * 
 * 입력 :7
 * 7은 소수
 * 
 * 입력 : 9
 * 9는 소수가 아님
 * 
 * 2~8까지 계속 나눠보다가 안되면 소수인 것
 */
public class Exam6 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int number;
		boolean flag = false; // 소수가 아닐 때 true, 소수일 때 false
		
		System.out.println("입력 : ");
		number = keyin.nextInt();
		
		for (int i=2; i<number/2; ++i) {
			if (number%i == 0) {
				flag = true;
				break; // continue: 반복문과 함께 사용
				// while 내부 사용시 조건식 쪽으로 이동
				// for 내부 증감식 쪽으로 이동
			}	
		}
		if (flag)
			System.out.println(number + "은 소수가 아님");
		else System.out.println(number + "은 소수");
		keyin.close(); 
	}
	
//		System.out.println("입력 : ");
//		number = keyin.nextInt();
//		
//		for (int i=2; i<=number/2; ++i) {
//			if (number%i != 1) continue;
//			else {
//				System.out.println(number + "은 소수");
//				keyin.close(); return;
//			}
//		}
//		
//		System.out.println(number + "은 소수가 아님");
//		keyin.close();
//	}

}
