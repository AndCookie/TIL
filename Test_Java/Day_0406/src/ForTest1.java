
public class ForTest1 {

	public static void main(String[] args) {
		// for�� �̿��Ͽ� 1~10���� ����ϴ� �ݺ����� �ۼ��Ͻÿ�. for
		for (int i=1; i<=10; ++i) {
			System.out.print(i + " ");
		}
		System.out.println(); // �ƹ��͵� ������ �� ������ ��
		
		// �빮�� A ~ Z���� �ݺ������� ���
		for (char j='A'; j<='Z'; ++j) {
			System.out.print(j + " ");
		}
		System.out.println(); // �ƹ��͵� ������ �� ������ ��
		
		// �빮�� A ~ �ҹ���z���� �ݺ������� ���
		for (char j='A'; j<='z'; ++j) {
			System.out.print(j + " ");
		}
		System.out.println(); // �ƹ��͵� ������ �� ������ ��

	}

}
