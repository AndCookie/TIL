import java.util.Scanner;

/*
 * [����2] BMI ����ϰ� ǥ�� ü�� �˷��ֱ�
�̸�, Ű(cm), ������(kg), bmi ���
bmi = ������ / Ű(m)�� ����
ǥ�� ü�� = (Ű(cm)-100) * 0.9

�� �� : 35 �̻�
��(��)�� �� (2�ܰ� ��) : 30 - 34.9
�浵 �� (1�ܰ� ��) : 25 - 29.9
��ü�� : 23 - 24.9
���� : 18.5 - 22.9
��ü�� : 18.5 �̸�

<���� ����>
name, height weight, bmi, result�Է� �ޱ�
 * 
 */
public class Exam2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String name, result;
		double height=0, weight=0, bmi=0, standardweight=0;
		
		System.out.print("�̸� �Է� : ");
		name = keyin.next();
		System.out.print("Ű(cm) �Է� : ");
		height = keyin.nextDouble();
		System.out.print("������(kg) �Է� : ");
		weight = keyin.nextDouble();
		
		bmi = weight / ((height/100) * (height/100));
//		if (bmi>35) result="�� ��";
//		else if (bmi>30) result="�ߵ� ��";
//		else if (bmi>25) result="�浵 ��";
//		else if (bmi>23) result="��ü��";
//		else if (bmi>18.5) result="����";
//		else result="��ü��";
		
		if (bmi<18.5) result="��ü��";
		else if (bmi<23) result="����";
		else if (bmi<25) result="��ü��";
		else if (bmi<30) result="�浵 ��";
		else if (bmi<35) result="�ߵ� ��";
		else result="�� ��";
		
		standardweight = (height-100) * 0.9;
		
		System.out.println();
		System.out.println("�̸�: " + name);
		System.out.println("Ű: " + height);
		System.out.println("������: " + weight);
		System.out.printf("BMI: %.2f%n", bmi);
		System.out.println("���: " + result);
		System.out.printf("ǥ��ü��: %.2f%n", standardweight);
		
		keyin.close();

	}

}
