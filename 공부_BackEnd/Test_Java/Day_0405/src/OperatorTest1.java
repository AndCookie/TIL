import java.util.Scanner;

public class OperatorTest1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		double height = 0; // �ʱ�ȭ
		
		System.out.print("Ű�� �Է��ϼ��� : ");
		height = keyin.nextDouble();
		
		// 160 ~ 170 �������� Ȯ��
		if ((height >= 160) && (height <= 170)) {
			System.out.println("Ű�� 160~170�Դϴ�.");
		}
		
		System.out.println("��!");
		
		
		
		keyin.close();
	}

}
