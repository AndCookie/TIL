import java.util.Scanner;

/* [����4]
 * ��(sec) �����ϱ�
 * 12345�ʴ� xx�ð� xx�� xx�� �Դϴ�.
 * 1�ð� = 60�� = 3600��
 * 1�� = 60��
 * <���࿹��>
 * �ʸ� �Է� : 61
 * 0�ð� 1�� 1��
 */
public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int hour, minute, second = 0; // ����� ����
		int time=0; //�Է¹��� ����
		
		System.out.print("�ʸ� �Է� : ");
		time = keyin.nextInt();
		hour = (time/3600 !=0)? time/3600 : 0;
		minute = (time/60 !=0)? (time-hour*3600)/60 : 0;
		second = (time !=0) ? (time-hour*3600-minute*60) : 0;
		
		System.out.println(hour + "�ð� " + minute + "�� " + second + "��");
		
		keyin.close();

	}

}
