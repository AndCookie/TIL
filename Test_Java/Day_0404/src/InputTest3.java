import java.util.Scanner;

public class InputTest3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //  �ڵ�  import : ctrl + shift + o
		
		// ���� ����
		int value;
		boolean result;
		
		// ������ �غ�
		System.out.print("�ڿ��� : ");
		value = keyin.nextInt();
		
		// ����
		result = value % 2 == 0;
		
		// ���
		System.out.printf("��� : " + result);
		
		keyin.close(); // �� �� ������ �����Ƿ� ���� ������ �ܰ迡 �Է��ؾ���
		
		
		// x�� y�� �� �¹ٲٱ�
		int x = 10;
		int y = 20;
		int temp; // �� ��(����)�� �غ��ϴ� ��!
		
		temp = x;
		x=y;
		y=temp;
		// ���̽㿡���� x, y = y, x ���� �¹ٲٱ� ����������
		// �ڹٿ����� �Ұ����ϹǷ� �� �ӽ� ������ ��������
		
		
		// 'A'(65) - 'a'(97) = ' '32
		System.out.println('a' - ' ');
		System.out.printf("��ȯ�� ��� : %c%n", ('a'- ' '));
		System.out.printf("��ȯ�� ��� : %c%n", ('A'+ 32));
	}

}
