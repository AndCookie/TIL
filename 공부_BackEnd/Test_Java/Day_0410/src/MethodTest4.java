
public class MethodTest4 {

	public static void main(String[] args) {
		int a =10, b=20;
		System.out.println("ȣ�� ��");
		System.out.println("a = " + a + ", b = " + b);
		
		exchange(a, b); // Call by value (���� ���� ȣ��)
		System.out.println("ȣ�� ��");
		System.out.println("a = " + a + ", b = " + b);
	}
	
	public static void exchange(int a, int b) {
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
		// ���⼭ a, b, temp�� ����������!!!
		// ���� 10�� 20�� ���� ���� �� exchange�Ͽ� 20�� 10�� �Ǵµ�
		// �޸� �󿡼� ���������� ���������� ������
		// ���������θ� exchange�ǰ� �ۿ����� exchange�� ���� Ȯ���� �� ���� ��
		// main�� ab�� exchange�� ab ���� �ּҰ��� ���� �ٸ�	
	}

}
