import java.util.Scanner;

/*
 * [����] ���׿����ڸ� �̿��Ͻÿ�.
 * �� ������ �� : 10
 * ��ü ���� ������ 154�� �� ��
 * �� ������ �ϱ��? 16������
 */
public class Exam2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		final int countPerPage = 10; // �������� �� ����
		int total = 0; // �� ���� ���� (�Է�)
		int page = 0; // �� ������ ����
		
		System.out.print("��ü ���� ���� : ");
		total = keyin.nextInt();
		
		page = total / countPerPage;
		page += (total%countPerPage > 0) ? 1 : 0;

		
		System.out.println("�ش� �Խ����� �� " + page + "������ �Դϴ�.");
		
		keyin.close();
	}

}
