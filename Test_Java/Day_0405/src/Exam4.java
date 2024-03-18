import java.util.Scanner;

/* [문제4]
 * 초(sec) 분해하기
 * 12345초는 xx시간 xx분 xx초 입니다.
 * 1시간 = 60분 = 3600초
 * 1분 = 60초
 * <실행예시>
 * 초를 입력 : 61
 * 0시간 1분 1초
 */
public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int hour, minute, second = 0; // 계산할 변수
		int time=0; //입력받을 변수
		
		System.out.print("초를 입력 : ");
		time = keyin.nextInt();
		hour = (time/3600 !=0)? time/3600 : 0;
		minute = (time/60 !=0)? (time-hour*3600)/60 : 0;
		second = (time !=0) ? (time-hour*3600-minute*60) : 0;
		
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
		
		keyin.close();

	}

}
