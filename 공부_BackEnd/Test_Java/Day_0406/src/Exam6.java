import java.util.Scanner;
/*
 * [����6] �Ҽ� �Ǻ�
 * ������ ������ �Է¹޾�, �ش� ������ �Ҽ����� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ�
 * �Ҽ��� ���� : 1�� �ڱ��ڽ� �ܿ��� ������ �������� �ʴ� ��
 * 
 * <���� ����>
 * �Է� : 3
 * 3�� �Ҽ�
 * 
 * �Է� :7
 * 7�� �Ҽ�
 * 
 * �Է� : 9
 * 9�� �Ҽ��� �ƴ�
 * 
 * 2~8���� ��� �������ٰ� �ȵǸ� �Ҽ��� ��
 */
public class Exam6 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int number;
		boolean flag = false; // �Ҽ��� �ƴ� �� true, �Ҽ��� �� false
		
		System.out.println("�Է� : ");
		number = keyin.nextInt();
		
		for (int i=2; i<number/2; ++i) {
			if (number%i == 0) {
				flag = true;
				break; // continue: �ݺ����� �Բ� ���
				// while ���� ���� ���ǽ� ������ �̵�
				// for ���� ������ ������ �̵�
			}	
		}
		if (flag)
			System.out.println(number + "�� �Ҽ��� �ƴ�");
		else System.out.println(number + "�� �Ҽ�");
		keyin.close(); 
	}
	
//		System.out.println("�Է� : ");
//		number = keyin.nextInt();
//		
//		for (int i=2; i<=number/2; ++i) {
//			if (number%i != 1) continue;
//			else {
//				System.out.println(number + "�� �Ҽ�");
//				keyin.close(); return;
//			}
//		}
//		
//		System.out.println(number + "�� �Ҽ��� �ƴ�");
//		keyin.close();
//	}

}
