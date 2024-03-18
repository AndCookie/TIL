import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 정수를 반복적으로 5회 입력받아 누적합을 구하고자 한다.
 * 만약 문자가 입력되어도 예외 발생으로 인한 프로그램이 종료되지 않아야 함.
 * 
 */
public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int num=0; // 입력용
		int total=0; // 누적용
		
		for (int i=0; i<5; ++i) {
			System.out.println("정수 : ");
			try {
				num = keyin.nextInt();
			} catch(InputMismatchException e) {
				--i;
				keyin.nextLine(); // 잘못 입력한 것이 inputBuffer에 그대로 남아있기 때문에 클리어 해줘야 함
				continue; // 증감식 ++i으로 이동
			}
			total += num;
			System.out.println("누적합: " + total);
		}
		
		keyin.close();
	}

}
