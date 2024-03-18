class MyStatic1 {
	int data1; // ����� ����
	static int data2 = 22; // ����� �ƴϰ� ���� class �ȿ� �������� ��!
	// Ŭ���� ������! // ��ü �������� �ʰ� �� �� ����
	
	// ������
	public MyStatic1(int data1) {
		// �⺻ ������ �ƴ�. �ܺο��� �����͸� �޾Ƽ� �ʱ�ȭ ���� ��
		this.data1 = data1;
	}
	
	// ���� �޼ҵ� -> ��ü �������� �ʰ� �� �� ����
	static void aMethod() {
		System.out.println("�̰��� ���� �޼ҵ� �Դϴ�." + data2);
		// static�� static�� ���� ���� : data2���� ������ �� ����.
//		System.out.println("�̰��� ���� �޼ҵ� �Դϴ�." + data1);
		// static�� non-static�� ���� �Ұ��� : data1���� ������ �� ����.
	}
}




class YourStatic { // ������� ���� �� static�̹Ƿ� ��ü ������ �ʿ� ����!
	static int dataA = 10;
	static int dataB = 20;
	final static double DATA_C = 42.195; // ��� (naming rule: ���� �빮���̰� �޸��� ����)
	
	static void methodB() {
		System.out.println("a= " + "dataA" + ", b= " + "dataB");
	}
	
	// ��� ���� static�� ��, �Ʒ��� ���� ���� �ڵ������ڰ� ���� �ܺο��� ���� ���� ������ �� �� ����
	private YourStatic() {}
}




public class StaticTest2 {

	public static void main(String[] args) {
		
		// ��ü �������� �ʰ� �� �� ����
		System.out.println(MyStatic1.data2); // static�� �����ü�� ǥ����
		// out�� System�̶�� class�� static�� �ֱ���~
		
		// ��ü �������� �ʰ� �� �� ����
		MyStatic1.aMethod();
		
		// ��ü ������ �ؾ߸� �� �� ����
		MyStatic1 s = new MyStatic1(15); // data1�� 15��� ������ �ʱ�ȭ
		System.out.println("���: " + s.data1);
		
		// YourStatic�� ��ü �������� �ʰ� �� �� ����
//		YoutStatic.methodB();
//		YourStatic ss = new YourStatic();
		// JVM�� �⺻ �����ڸ� �������� ������ ���� �����߾�����
		// private YourStatic() {} ���ָ� ���� �Ұ�
	}

}
