import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int egg; // 5~7g �̻��̸� �Ǹ�. 5�̸��� �ǸźҰ�, 7�ʰ��� �ǸźҰ�
		
		System.out.print("�ް� ���� �Է� : ");
		egg = keyin.nextInt();
		
		if (egg>=5 && egg<=7)
			System.out.println("�ǸŰ���");
		else
			System.out.println("�ǸźҰ���");	
		
		keyin.close();

	}

}
