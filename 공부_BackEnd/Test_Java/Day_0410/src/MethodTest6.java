
public class MethodTest6 {

	public static void main(String[] args) {
		double[] ary = myMethod();
		System.out.println(ary); // �ּҰ��� ���� (100����)
		System.out.println(ary[0]);
		System.out.println(ary[1]);
		
		String data = yourMethod();
		yourMethod(); // ''char(�⺻�ڷ���), "" String(��ü)
		System.out.println(data);
	}
	
	public static double[] myMethod() {
		// main�� static�̹Ƿ� ���⵵ static�ؾ� ȣ�� ����
		double[] ary = {1.2, 3.4}; // �ʱ�ȭ
		return ary;
	}
	
	public static String yourMethod() {
		return "Hello world!";
	}

}
