import java.util.Scanner;

/*[문제5] 365.2422일
 * 1년은 365일 xx시간 xx분 xx초
 * 1일 = 24시간 = 3600*24초
 */
public class Exam5 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int day=0, time=0, hour=0, minute=0, second = 0; // 계산할 변수
		double year; //입력받을 변수 // 365.2422
		
		System.out.print("일수를 입력 : ");
		year = keyin.nextDouble();
		day = (int) (year/1);
		time = (int) ((year-day)%1*3600*24);
		hour = (time/3600 !=0)? time/3600 : 0;
		minute = (time/60 !=0)? (time-hour*3600)/60 : 0;
		second = (time !=0) ? (time-hour*3600-minute*60) : 0;
		
		System.out.println(day + "일 " + hour + "시간 " + minute + "분 " + second + "초");
		// 5시간 48분 46.08초
		keyin.close();

	}

}
