
public class ArrayTest3 {

	public static void main(String[] args) {
		int a=10, b=10;
		if (a==b) System.out.println("���� ��");
		else System.out.println("�ٸ� ��");
		
		String s1 = "ȫ�浿"; // String Pool
		String s2 = "ȫ�浿";
		String s3 = new String("ȫ�浿");
		
		// �Ϲ� �񱳿����� ���� ������(�ּ�)�� ����
		// s1�� ȫ�浿 �� ��, s2�� ���� ȫ�浿�� ������ �ʰ� ã�ٺ���
		// s1,s2 �� ���� �ּҰ��� ���� �ȴ�.
		// new ȫ�浿�� �����ϸ�, �ּҰ��� �ٸ� ����
		
		// ������ (�ּҸ� ��)
		if (s1 == s2) System.out.println("���� ��");
		else System.out.println("�ٸ� ��");
		
		// �ּҸ� ��
		if (s1 == s3) System.out.println("���� ��");
		else System.out.println("�ٸ� ��");
		
		// ������ ��
		if (s2.equals(s3)) System.out.println("���� ��");
		else System.out.println("�ٸ� ��");
		
		
		// ============================================
		String b1 = "ȫ�浿";
		String b2 = "ȫ�浿"; // b1�� b2�� �ּҰ��� ����
		b2 = "����ġ"; // b2�� �ּҰ��� ���� ����� ��
		b1 = "�տ���"; // b1�� ���ο� �ּҰ��� ���ԵǾ�, ȫ�浿�� ������ �ݷ��Ϳ� ���� ������
		// ȫ�浿 : GC�� ���� �޸𸮿��� ���� : ��� ���ŵǴ� ���� �ƴ� : �켱������ �����Ƿ� CPU�� �Ѱ��� �� ���ŵ� ����
		String temp = "�ȳ��ϼ���" + "������" + "ooo" + "ooo";
	}

}
