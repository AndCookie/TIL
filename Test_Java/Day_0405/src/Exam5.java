import java.util.Scanner;

/*[����5] 365.2422��
 * 1���� 365�� xx�ð� xx�� xx��
 * 1�� = 24�ð� = 3600*24��
 */
public class Exam5 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int day=0, time=0, hour=0, minute=0, second = 0; // ����� ����
		double year; //�Է¹��� ���� // 365.2422
		
		System.out.print("�ϼ��� �Է� : ");
		year = keyin.nextDouble();
		day = (int) (year/1);
		time = (int) ((year-day)%1*3600*24);
		hour = (time/3600 !=0)? time/3600 : 0;
		minute = (time/60 !=0)? (time-hour*3600)/60 : 0;
		second = (time !=0) ? (time-hour*3600-minute*60) : 0;
		
		System.out.println(day + "�� " + hour + "�ð� " + minute + "�� " + second + "��");
		// 5�ð� 48�� 46.08��
		keyin.close();

	}

}
