import java.util.Scanner;

public class InputTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //ctrl + shift + o
		int age;
		double height;
		String name;
		
		System.out.print("���̸� �Է� : ");
		age = scanner.nextInt();
		
		System.out.print("Ű�� �Է� : ");
		height = scanner.nextDouble();
		
		System.out.print("�̸��� �Է� : ");
		name = scanner.next();
		
		System.out.println(name + ", "+ age + "��, " + height +  "cm");
		
		scanner.close(); // �� �� ������ �����Ƿ� ���� ������ �ܰ迡 �Է��ؾ���
	}

}
