import java.util.Scanner;

/*[����-6] ������ ��� ���ϱ�
�� ������ ������ �Է� �޾� ������ ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
<���࿹>
���� ���� : 90
���� ���� : 87
���� ���� : 99
���� : 276, ��� : 92.0
 */

public class Exam6 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int kor=0, eng=0, math=0, total=0;
		double mean=0;
		String result;
		
		System.out.print("���� ���� : ");
		kor = keyin.nextInt();
		System.out.print("���� ���� : ");
		eng = keyin.nextInt();
		System.out.print("���� ���� : ");
		math = keyin.nextInt();
		
		total = kor + eng + math;
		mean = total/3.0;
		
		System.out.println("���� ���� : " + kor);
		System.out.println("���� ���� : " + eng);
		System.out.println("���� ���� : " + math);
		System.out.printf("����: %d, ��� :%.1f%n", total, mean);
		
		keyin.close();
	}

}
