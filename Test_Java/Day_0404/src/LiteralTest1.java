
public class LiteralTest1 {
	public static void main(String[] args) {
		byte by = 12;
		short sh = 45;
		int a = 42; // ���� ���� ���Ǵ� ������ �⺻ ���
		long ln =45L;
		
		int binary = 0b1011;
		int octal = 0125;
		int hexa = 0xff0000;
		
		System.out.println(binary); // 10������ �����
		System.out.println(octal); // 10������ ��ȯ�� ����� ��µ�
		System.out.println(hexa); // 16
		
		float f1 = 3.14f;
		double d1 = 3.14;
		double d2 = 1.5e5;
		double d3 = 1.5e-7;
		System.out.println(d2);
		System.out.println(d3);
		
		char ch = 'a';
		System.out.println(ch);
		System.out.println(ch+0); // 'a' --> 97
		// System.out.println((char)(ch+1));
		// + ������ �ϸ� ������ ��ȯ�Ǿ� ����
		// char + int ==> int int => ������ �ǽ��ϰ� ����� ������
		// (char���� int�� ũ�� ����)
		// Promotion : ���Կ����� ���θ������ �ʴ´�.
		System.out.println((char)(ch+1));
		// Casting : �����ڰ� ��������� 
		char ch1 = 'A';
		System.out.println(ch1+1); // 'A' -->65
		System.out.println(ch>ch1); // true
		char ch2='��';
		System.out.println(ch2+0);
		
	}

}
