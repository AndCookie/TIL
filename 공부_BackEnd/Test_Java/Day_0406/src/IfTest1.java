/*
 * if�� ���� 1
 * - ���๮�� �� �� ���� ���� �߰�ȣ ���� ����
 *
 * ��ü���� (ctrl+a) -> ctrl+i(indent)
 * 
 */
public class IfTest1 {

	public static void main(String[] args) {
		// v1
		int a = 10;
		if (a>5)
			System.out.println("ū ���̴�.");
		System.out.println("��!"); // indent �ڵ� �鿩����
		
		
		// v2. ������� ��������. 0�� ����
		int b = -9;	
		if (b>0) {
			System.out.println("���");
		} else {
			System.out.println("����");
		}
		// �߰�ȣ �����ص� �ǰ� �� �ٷ� �ᵵ ��
		if (b>0) System.out.println("���");
		else System.out.println("����");
		
		
		
		// v3. ������� �������� 0����
		int c = -9;
		if (c>0) {
			System.out.println("���");
		} else if (c<0) {
			System.out.println("����");
		} else {
			System.out.println("0");
		}
		// �߰�ȣ �����ص� �ǰ� �� �ٷ� �ᵵ ��
		if (c>0) System.out.println("���");
		else if (c<0) System.out.println("����");
		else System.out.println("0");

		
	}

}
