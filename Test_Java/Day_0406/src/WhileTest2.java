/* 
 * [����]
������ �ݺ������� �Է��Ͽ� �������� ����Ѵ�
0�� �ԷµǸ� �����Ѵ�.

 * 
 */
import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value =0, sum=0;
		
		while (true) {
			System.out.println("���� �Է� : ");
			value = keyin.nextInt();
			if (value == 0) break;
			
			sum += value;
			System.out.println("�Է� ������  : " + value);
		}
		System.out.println("�Էµ� �������� ���� : " + sum);
		keyin.close();

	}

}
