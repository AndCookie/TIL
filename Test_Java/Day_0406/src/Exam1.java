import java.util.Scanner;

/*
 * [����1] �˹ٺ� ���ϱ�
�ð��� 9260���� �޴� �˹ٸ� �ϰ� �ִ�.
�⺻�ð� 1��/5�ð�
�߰��ð� 500���� �߰������� �� �ޱ�� �Ѵ�.
������ (5��) ���� �ð��� �Է¹޴´�.
������ �ݾ��� ����Ͻÿ�.

<���� ����>
�ٹ��ð� �Է� : __
�⺻�ݾ� :
�߰��ݾ� :
�Ѽ��ɾ�:
 */
public class Exam1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		final int base = 9260;
		final int overtime = base + 500;
		int time=0, basetotal=0, overtotal=0, total=0;
		
		System.out.print("�ٹ��ð� �Է� : ");
		time = keyin.nextInt();
		if (time <= 25) {
			basetotal = time * base;
		} else {
			basetotal = 25 * base;
			overtotal = (time-25) * overtime;
			total = basetotal + overtotal;
		}
		
		System.out.println("�⺻�ݾ� : " + basetotal);
		System.out.println("�߰��ݾ� : " + overtotal);
		System.out.println("�Ѽ��ɾ� : " + total);
				
		keyin.close();


	}

}
