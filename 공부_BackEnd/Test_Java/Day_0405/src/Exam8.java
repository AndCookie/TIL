import java.util.Scanner;

/*
 * [����-8] �հ� ���ϱ�
 * Ű����� 0���� 999������ ������ �Է� ���� �� ������ �ڸ����� ���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * <���� ����>
 * 0~999������ ���� �Է� : 456
 * 15
 * 
 * 0~999������ ���� �Է� : 123
 * 6
 */
public class Exam8 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int input, result=0;
		
		System.out.print("0~999������ ���� �Է� : ");
		input = keyin.nextInt();
		result = (input/100) + (input%100)/10 + (input%10)/1 ;
		System.out.println(result);
		
		keyin.close();

	}

}
