import java.util.Scanner;

/*
 * [문제1] 알바비 구하기
시간당 9260원을 받는 알바를 하고 있다.
기본시간 1일/5시간
추가시간 500원을 추가적으로 더 받기로 한다.
일주일 (5일) 일한 시간을 입력받는다.
수령할 금액을 출력하시오.

<실행 예시>
근무시간 입력 : __
기본금액 :
추가금액 :
총수령액:
 */
public class Exam1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		final int base = 9260;
		final int overtime = base + 500;
		int time=0, basetotal=0, overtotal=0, total=0;
		
		System.out.print("근무시간 입력 : ");
		time = keyin.nextInt();
		if (time <= 25) {
			basetotal = time * base;
		} else {
			basetotal = 25 * base;
			overtotal = (time-25) * overtime;
			total = basetotal + overtotal;
		}
		
		System.out.println("기본금액 : " + basetotal);
		System.out.println("추가금액 : " + overtotal);
		System.out.println("총수령액 : " + total);
				
		keyin.close();


	}

}
