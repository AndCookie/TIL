import java.util.Scanner;

/*
 * [����3] �������� ���� // temp ���� ���
���� 3���� �Է� ���� ��, (���� ���� �Է����� ����)
���� ���������� ������� ����ϱ�
<���� ����>
34
15
23
��� : 15 23 34
 * 
 * 
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int max, min, median, temp;
		
		System.out.print("ù ��° ���� �Է� : "); max = keyin.nextInt();
		System.out.print("�� ��° ���� �Է� : ");	min = keyin.nextInt();
		System.out.print("�� ��° ���� �Է� : "); median = keyin.nextInt();
		
		if (max < min) {
			temp = max;
			max = min;
			min = temp;
		}
		
		if (max < median) {
			temp = max;
			max = median;
			median = temp;
		}
		
		if (median < min) {
			temp = median;
			median = min;
			min = temp;
		}
		
		System.out.println(min + " " + median + " " + max);
		
		keyin.close();
	}

}
