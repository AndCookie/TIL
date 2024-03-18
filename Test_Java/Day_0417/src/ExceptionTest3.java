
public class ExceptionTest3 {

	// -1�� ���� �������� �ʴ´ٴ� ������ �ñ׳η� ����� ��� =========
//	public static void main(String[] args) {
//		int result = divide(20, -10);
//		if (result == -1) {
//			System.out.println("���� : ���� ó�� �Ұ�");
//			return;
//
//		} 
//		System.out.println("�� : " + result);
//	}
//	
//	public static int divide(int a, int b) {
//		if (b<=0) return -1;
//		return a/b;
//		// ���� ó���� ���� int�� ��ȯ
//	}
//}	

	
	
	
	// try-exception ======== �и� �����̰ų� 0�̸� �ͼ������� ó�� ==========
//	public static void main(String[] args) {
//		int result = 0; // try �ۿ��� result�� ��������� ���������� �ƴ� ���������� ��� ����
//		try {
//			result = divide(20, -10);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} 
//		System.out.println("�� : " + result);
//	}
//		
//	public static int divide(int a, int b) throws Exception {
//		if (b<=0) {
//			throw new Exception("���� ó�� �Ұ�");
//			// new : ��ü ����
//			// throw : �޼ҵ带 ȣ���ߴ� ������ exception�� ������ (return�� ����)
//		}
//		return a/b;
//		// ������ ó���� ���� ȣ���ߴ� ���� int result = divide(20, 10);�� ���ư�
//	}
//}

	
	
	// try-exception ======== �� ���� ������ �� 20���� ũ�� �ͼ������� ó�� ==========
	// ���� : �ͼ����� ������ ���̻� �Ʒ��� �ڵ带 �������� �ʰ� ��������
	public static void main(String[] args) throws Exception {
		// ���� ���� : ������ �ذ����� �ʰ� ���ܸ� ���������� ��!!
		int result = 0;
		add(10, 20);
		System.out.println(result);
	}	
	
	
	public static int add(int a, int b) throws Exception {
		int result = a+b;
		
		if (result>=20) {
			throw new Exception("���� 20���� ũ�� �ȵ�!");
			// new : ��ü ����
			// throw : �޼ҵ带 ȣ���ߴ� ������ exception�� ������ (return�� ����)
		}
		return result;
		// ������ ó���� ���� ȣ���ߴ� ���� int result = divide(20, 10);�� ���ư�
	}
	// �ͼ����� ó���ߴٰ� ����� �������.. �츮�� ���� �ͼ��� ������ ���ԵǾ� �ִ�
	// "���� 20���� ũ�� �ȵ�!"

}