import java.util.Scanner;

public class MethodTest2 {

	public static void main(String[] args) {
		// �̸� a, b�� ���� �����Ͽ� ��Ģ���� �����ϱ�
//		int a = 15, b=23;
		// Ű����κ��� a, b�� ���� �Է¹޾� ��Ģ������ �����Ͻÿ�.
		int a, b;
		Scanner keyin = new Scanner(System.in);
		System.out.println("���� 2���� �Է��Ͻÿ� : ");
		a = keyin.nextInt();
		b = keyin.nextInt();
		
		System.out.println("������ ���: " + add(a,b));
		System.out.println("������ ���: " + substract(a,b));
		System.out.println("������ ���: " + multiply(a,b));
		System.out.println("�������� ���: " + divide(a,b));
		
		keyin.close();
	}
	// �� ���� ���� �޾Ƽ� ����� ��ȯ
	public static int add(int num1, int num2) {
		// �ܺ� (�޼ҵ� ��)���� �����͸� �ް� ���� ��ȯ
		return num1 + num2;
		// 15+23 = 38
		// ��ȯ�Ǵ� ���� num1, num2�� �޸𸮿��� �����
	}
	public static int substract(int num1, int num2) {
		return num1 - num2;
	}
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public static int divide(int num1, int num2) {
		// �Ҽ����� ����ϱ� ����� �޼ҵ�
		return num1 / num2;
	}



}
