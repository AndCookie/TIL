import java.util.Scanner;

/*
 * [����4]
�ް��� ���Ը� �ݺ������� �Է� �޴´�.
5~7g�� ���ϰ� ������ �ް��̴�.
5���� ��ŷ�� �Ϸ�Ǹ� �����Ѵ�. 
 */
public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int i = 0;
		double weight=0;
		
		
		while (true) {
			System.out.println("�ް� ���� �Է� : ");
			weight = keyin.nextDouble();
			if ((weight>=5) && (weight<=7)) {
				++i;
				System.out.println(i + "�� ����");
			} else System.out.println("���� �Ұ�");
			
			if (i==5) break;
		}
		System.out.println("5�� ��ŷ�� �Ϸ�Ǿ����ϴ�!");	
		System.out.println("** 1�� ����");	
		keyin.close();
	}
}