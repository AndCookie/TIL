
public class MethodTest5 {

	public static void main(String[] args) {
		int[] arr = {10, 20}; // ������ ����
		// arr�� 100, heap�� 10,20�� �����ǰ� �ּҰ� ���� 111,222��� �޸𸮻��� arr�� �����ϴ� �� 1,2������ �Ǵ� ��
		System.out.println("ȣ�� ��");
		System.out.println("arr[0] = " + arr[0] + ", arr[1] = " + arr[1]);
		
		exchange(arr); // Call by reference (�������� ���� ȣ�� : ���� ���� ����)
		System.out.println("ȣ�� ��");
		System.out.println("arr[0] = " + arr[0] + ", arr[1] = " + arr[1]);
		// �迭�� ������, �����Ǵ� ��ġ���� �ް� �ǹǷ� ������ ���� �����ϴ�
	}
	
	public static void exchange(int[] b) {
		// �迭�� ����Ǿ����Ƿ� �迭�� �޴� ��
		// main���� arr�� int�� ����Ǿ����Ƿ� �Ű�������  int[] b�� ���� ��
		// main�� �Ű������� string ���ڿ��̱� ������ ������ ��
		// b�� �ּҰ��� 100, heap�� 10�� 20�� �޴� ��
		int temp;
		temp = b[0];
		b[0] = b[1];
		b[1] = temp;	
	}

}
