
public class OperatorTest1 {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/(double)b);
		// ���� ������ ������ ������� �Ǽ����� �ƴ� �������̾�� �ϹǷ�
		// int ������ double�� ������� �Ǽ��� (promotion)
		System.out.println(a%b);
		// promotion -> casting
		System.out.println("������ ���:" + (a+b));
		System.out.println("������ ���:" + a + b);
		System.out.println("������ ���:" + (a-b));
		// System.out.println("������ ���:" + a - b);
		System.out.println("������ ���:" + a * b);
		// ���ڿ� ���ϱ� double�� ������� ���ڿ�
		// ���ϱ�� ������ �켱������ �����ϴٸ� ���չ����� �߿��ѵ�
		// ���ڿ� ���� double => ���� �߻�
		// ���ϱ�� ���� �� ������ �켱������ �����Ƿ� ���� ���� �߻� x
		
	}

}
