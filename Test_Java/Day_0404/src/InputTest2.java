import java.util.Scanner;

public class InputTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //  �ڵ�  import : ctrl + shift + o
		
		// ���� ����
		double radius, area;
		final double pi = 3.141592;
		
		// ������ �غ�
		System.out.print("������ x�� �Է� : ");
		radius = scanner.nextDouble();
		
		// ����
		area = pi * (radius * radius);
		
		// ���
		System.out.printf("������ %.2f�� ���� ������ %.2f�Դϴ�.", radius, area);
		
		scanner.close(); // �� �� ������ �����Ƿ� ���� ������ �ܰ迡 �Է��ؾ���
	}

}
