
public class StringBufferTest {

	public static void main(String[] args) {
		// String�� �޸� new ������ �ʼ��̸� ���� �Ұ�!!!
		StringBuffer sb1 = new StringBuffer(); // �⺻������
		System.out.println("�뷮: "+sb1.capacity()); // default=16
		
		StringBuffer sb2 = new StringBuffer("���ع��� ��λ��� ");
		System.out.println("�뷮: "+sb2.capacity()); // 26 = 16+10
		
		String temp = "���ع��� ��λ��� ";
		System.out.println("���� ����: " + temp.length()); // 10
		// ���ڿ����� capacity��� ���� ��ü�� �ƿ� ����
		// temp.length()�� �뷮�� �ƴ�, ���� ������ ������ �˷��ִ� ��
		
		sb2.append("�⵵�� "); // ���� �߰�
		sb2.insert(10, "������ "); // �߰��� �߰�
		System.out.println(sb2);
		System.out.println("���� ����: " + sb2.length()); // ���� ���� 18
		System.out.println("�뷮: "+sb2.capacity()); // �뷮 26
		
		sb2.delete(0, 5);
		System.out.println(sb2);
		System.out.println(sb2.reverse());
		System.out.println("���� ����: " + sb2.length()); // ���� ���� 18
		System.out.println("�뷮: "+sb2.capacity()); // �뷮 26
		
		sb2.trimToSize(); // �����ִ� �뷮�� �����Ͽ� ��� ���� ����
		System.out.println(sb2);
		System.out.println("���� ����: " + sb2.length()); // ���� ���� 13
		System.out.println("�뷮: "+sb2.capacity()); // �뷮 13
		
		String data = sb2.toString();
		// StringBuffer�� String���� �ٲ㼭
		// immutable, �� ���� �Ұ����� ������ �����
		// String�� + ���ϱ� �����ڷ� �߰��ϸ� �Ź� ���ο� ���ڿ��� �����ϰ� �ǹǷ� �޸� ���� �߻�
		// StringBuffer�� append �� �� �������� String���� ��ȯ���ָ� ����!!
		System.out.println(data);
		
	}

}