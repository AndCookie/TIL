
public class ExceptionTest1 {

	public static void main(String[] args) {
		try {
			int a=10, b=0;
//			int a=10, b=5;
			int result = a/b;
			System.out.println("�ͼ����� ������ ������ �ڵ�: " + result); // ��� x
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
		} finally {
			System.out.println("������ ����! => �ַ� �޸����� �ڵ�� ");   // ��� o
		}
		
		System.out.println("��!!!"); // ====== try-catch�� ���� ====== ��� o
	}
}
