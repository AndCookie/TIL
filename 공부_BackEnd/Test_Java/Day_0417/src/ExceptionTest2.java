import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * ������ �ݺ������� 5ȸ �Է¹޾� �������� ���ϰ��� �Ѵ�.
 * ���� ���ڰ� �ԷµǾ ���� �߻����� ���� ���α׷��� ������� �ʾƾ� ��.
 * 
 */
public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int num=0; // �Է¿�
		int total=0; // ������
		
		for (int i=0; i<5; ++i) {
			System.out.println("���� : ");
			try {
				num = keyin.nextInt();
			} catch(InputMismatchException e) {
				--i;
				keyin.nextLine(); // �߸� �Է��� ���� inputBuffer�� �״�� �����ֱ� ������ Ŭ���� ����� ��
				continue; // ������ ++i���� �̵�
			}
			total += num;
			System.out.println("������: " + total);
		}
		
		keyin.close();
	}

}
