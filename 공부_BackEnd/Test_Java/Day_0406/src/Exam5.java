import java.util.Scanner;

/*
 * [����] ������
 * 2~9 ������ ������ �Է¹޾�, �ش��ϴ� ���� �������� ����Ͻÿ�.
 * 2 * 1 = 2
 * 2 * 2 = 4
 * 2 * 3 = 6
 * 2 * 4 = 8
 *...
 * 2 * 9 = 18 
 *
 */
public class Exam5 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int dan = 0;
		
		System.out.println("2~9 ������ ���� �Է� : ");
		dan = keyin.nextInt();
		
		if ((dan>=2) && (dan<=9)) {
			for (int i=1; i<=9; ++i) {
				System.out.print(dan + " * " + i + " = " + (dan * i));
				System.out.println();
			}
		} else System.out.println("�ٸ� ������ �Է����ּ���");
		
		keyin.close();

	}

}
