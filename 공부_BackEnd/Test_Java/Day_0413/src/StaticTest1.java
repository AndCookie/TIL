class MyStatic { // concrete class�̹Ƿ� �ݵ�� ��ü�� �����ؾ� �� �� �ִ�
	// �Ϲ� ���
	// ���ǻ� private �����ϰ���
	int data1;
	
	// ������
	public MyStatic(int data1) {
		// �⺻ ������ �ƴ�. �ܺο��� �����͸� �޾Ƽ� �ʱ�ȭ ���� ��
		this.data1 = data1;
	}
}


public class StaticTest1 {

	public static void main(String[] args) {
		MyStatic s = new MyStatic(15); // data1�� 15��� ������ �ʱ�ȭ
		System.out.println("���: " + s.data1);
	}

}
