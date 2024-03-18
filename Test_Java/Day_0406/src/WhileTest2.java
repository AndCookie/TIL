/* 
 * [연습]
정수를 반복적으로 입력하여 누적값을 출력한다
0이 입력되면 종료한다.

 * 
 */
import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value =0, sum=0;
		
		while (true) {
			System.out.println("정수 입력 : ");
			value = keyin.nextInt();
			if (value == 0) break;
			
			sum += value;
			System.out.println("입력 데이터  : " + value);
		}
		System.out.println("입력된 데이터의 총합 : " + sum);
		keyin.close();

	}

}
