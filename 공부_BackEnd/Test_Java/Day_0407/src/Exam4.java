import java.util.Scanner;
/*
 * [����4] �Ҽ� �Ǻ� �� ���
 * ������ ������ �Է¹޾�, �ش� ������ �Ҽ����� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ�
 * �Ҽ��� ���� : 1�� �ڱ��ڽ� �ܿ��� ������ �������� �ʴ� ��
 * 
 * <���� ����>
 * ���� �Է� : 9
 * 2 3 5 7 ��!
 * 
 */

public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int number;
		
		// Loop
		System.out.println("���� �Է� : ");
		number = keyin.nextInt();
		
		Loop :
		for (int i=2; i<number; ++i) {
			for (int j=2; j<i; ++j) {
				if (i%j == 0) continue Loop; // �Ҽ��� �ƴ�
			}
			System.out.print(i + " ");
		}
		System.out.println("��!");
		keyin.close(); 

	}


}
