
public class MethodTest1 {
		// ������ main���� ���� ����
	public static void main(String[] args) {
		// �̸� ������ ������ ��Ģ���� �����ϱ�
		int result = 0; // ���� ����
		// main�� jvm�� �˾Ƽ� ȣ�����ִµ�
		// add1�� ȥ�ڼ� ������ �� �����Ƿ�
		// main���� �ҷ���� �Ѵ�.
		
		System.out.println("���α׷��� ���۵�!");
		add1(); // �����ü : add1�� static�̶�� �ǹ�
		// �ٷ� add1���� �̵��ߴٰ� ���� �� ��ȣ�� ���� ��� �ٽ� ����� ���ƿ´�
		// "call�ؼ� add1���� ��� �Ѿ��"
		
		result = add2();
//		add2();
		// 1�ܰ� : add2() : add2ȣ��
		// 2�ܰ� : = : ���� (������ ��ȯ�� ���� �������� ������, �� ���� ������ result�� 0���� ��µ�)
		// ������ ��ȯ�� 
		System.out.println("add2()�� ���: " + result);
		
		result = add3(12, 23); // �ƱԸ�Ʈ(Argument) = ��������
		// 12 = int num1 / 23 = int num2
		// result = num1 + num2 = 12+23 = 35;
		System.out.println("add3()�� ���: " + result);
		
	}
	
	public static void add1() {
		// �޼ҵ�� : add1
		// void : ��ȯ Ÿ�� ����
		// public static void add1() : �޼ҵ� �ñ״�ó : ��� �� �� �뷫 ���� ���� �� �ֱ� ����
		int num1 = 10;
		int num2 = 20;
		
		int result = num1 + num2;
		System.out.println("���� ���: " + result);
		// return; // ��ȯ�� ���� ���� ������ return ��ü�� ���� ����
	}
	
	public static int add2() {
		// int : �۾� �� ������ �������� ��ȯ�ؾ� ��
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		// �޼ҵ� �ȿ��� ����� ������ ���������̹Ƿ�
		// add1������ add2������ �������� ������ ��� ����
		return result; // ������ ���� �߻�
	}
	
	public static int add3(int num1, int num2) {
		// int : �۾� �� ������ �������� ��ȯ�ؾ� ��
		// (int num1, int num2) : �Ű����� = �Ķ����
		// ���ο��� �����͸� ����� ���� �ƴ϶�
		// ���� ���ڷκ��� ����  add�� �����͸� ���� �޴� ��
		int result = num1 + num2;
		return result;
	}
	
}
