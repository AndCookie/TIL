import java.util.Scanner;

/* [����3] ���׿����� ���
 * ������ �Է¹޾� Ȧ������ ¦������ ����Ͻÿ�
 * int value;
 * Scanner keyin;
 * String result; // ���ڿ�("Ȧ��", "¦��")�� ���� ����
 * <���� ����>
 * ���� �Է� : _
 * _�� Ȧ��
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		int value = 0;
		String result;
		
		System.out.print("���� �Է� : ");
		value = keyin.nextInt();
		result = (value%2==0) ? "¦��" : "Ȧ��";
		System.out.println(value + "�� " + result);
		
		keyin.close();
	}

}
