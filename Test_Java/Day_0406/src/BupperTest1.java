import java.util.Scanner;

public class BupperTest1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int a;
		double b;
		String c, d;
		
		System.out.println("���� 3�� �Է�: ");
		a = keyin.nextInt();
		b = keyin.nextDouble();
		c = keyin.next();
		d = keyin.nextLine(); // �� �� ��ü�� ������
		System.out.println(a + ", " + b + ", " + c + ", " + d);
		
		keyin.close();

	}

}
