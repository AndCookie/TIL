import java.util.Scanner;

/*[����-7] �� ������ ������ �Է� �޾� �հ�/���հݿ��� �Ǻ��ϱ�(���� ����)
����, ����, ������ ������ �Է�.
����� �ݵ�� 80�� �̻��̾�� ����ϰ�, ����� �ݵ�� 70�� �̻��̾�� �Ѵ�.
�� �����̶� 50�� �̸��� ���� �������� ���հ�.
��հ� �հ� ���θ� ����Ͻÿ�
 */
public class Exam7 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int kor=0, eng=0, math=0, total=0;
		double mean=0;
		String result;
		
		System.out.print("���� ���� : ");
		kor = keyin.nextInt();
		System.out.print("���� ���� : ");
		eng = keyin.nextInt();
		System.out.print("���� ���� : ");
		math = keyin.nextInt();
		
		mean = (kor + eng + math)/3.0;
		result = (kor>=50 && eng>=80 && math>=50 && mean>=70) ? "�հ�" : "���հ�";
		
		System.out.printf("��� ���� : %.2f%n" + mean);
		System.out.println("�հ� ���� : " + result);
		
		keyin.close();

	}

}
