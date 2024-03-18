import java.util.Scanner;

public class InputTest3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //  자동  import : ctrl + shift + o
		
		// 변수 선언
		int value;
		boolean result;
		
		// 데이터 준비
		System.out.print("자연수 : ");
		value = keyin.nextInt();
		
		// 연산
		result = value % 2 == 0;
		
		// 출력
		System.out.printf("결과 : " + result);
		
		keyin.close(); // 한 번 닫으면 끝나므로 가장 마지막 단계에 입력해야함
		
		
		// x와 y의 값 맞바꾸기
		int x = 10;
		int y = 20;
		int temp; // 빈 컵(공간)을 준비하는 것!
		
		temp = x;
		x=y;
		y=temp;
		// 파이썬에서는 x, y = y, x 으로 맞바꾸기 가능하지만
		// 자바에서는 불가능하므로 꼭 임시 공간을 만들어야함
		
		
		// 'A'(65) - 'a'(97) = ' '32
		System.out.println('a' - ' ');
		System.out.printf("변환된 결과 : %c%n", ('a'- ' '));
		System.out.printf("변환된 결과 : %c%n", ('A'+ 32));
	}

}
