import java.util.Scanner;
/* [����]
 * ���̰� 6�� �̸��̰ų� 65�� �ʰ��̸�
 * 5% ����
 * 
 */
public class Exam1 {

	public static void main(String[] args) {
		final int price = 25000;
		int age = 0;
		int fee;
		double discount;
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		
		System.out.print("���̸� �Է��ϼ��� : ");
		age = keyin.nextInt();
		
		discount = (age<6 || age>65) ? 0.05 : 0;
		System.out.println("�������� " + discount);
		fee = (int) (price*(1-discount));
		
//		if ((age<6) || (age>65)) {
//			fee = (int) (price * 0.95);
//			// 1. ����
//			// System.out.println("�����" + fee + "�Դϴ�.");
//			// return; // ȣ���ߴ� ������ �ٽ� �ǵ��ư����� �ǹ�
//			// 2. elif
//		} else {
//			fee = price;
//		}
		System.out.println("����� " + fee + "�� �Դϴ�.");
		keyin.close();
		
	}

}
