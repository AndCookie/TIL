
public class MethodTest3 {
	// static �޼ҵ�� non-static�� ���� �Ұ�!
	// �ݴ�� non-static �޼ҵ�� static�� ���� ����
	// static����, non-static������ ȣ�� ����
	// static�� �̸� �޸𸮿� �ö��������, unstatic�� �޸𸮿� �ö���� ���߱� ����
	// ���� unstatic�� ����ϴ� ������ �޸� ����
	public static void main(String[] args) {
		methodA();
//		methodB();
//		methodC();
		// �޼ҵ� CALL �Ұ��ϹǷ� ���� �߻�
		// => ������ �Ŀ�(�޸𸮿� �ε��� �Ŀ�)�� ����� ��������
	}
	// Ŭ������ �޼ҵ带 �����ϱ� ���� �ۿ��ٰ� ���ο� �޼ҵ�� ����� ��
	
	public static void methodA() {
		System.out.println("static �޼ҵ�(methodA)�Դϴ�.");
//		methodC();
	}
	
	public void methodB() {
		System.out.println("non-static �޼ҵ�(methodB)�Դϴ�.");
		methodC(); // non-static���� ȣ�� ����
		methodA(); // methodA�� �̹� ȣ��Ǿ������Ƿ� ȣ�� ����
	}
	
	public void methodC() {
		System.out.println("non-static �޼ҵ�(methodC)�Դϴ�.");
	}

}
