
public class BitTest1 {

	public static void main(String[] args) {
		int a = 2147483647;
//		System.out.println(a+1);
		int b = 0xffffffff; //4byte : f 8�� : ��ü ��Ʈ�� 1�� ä�� �� ����
//		System.out.println(b);
		
		// ~ (1�� ���� ������: 1's complement: ���׿�����)
		int c = 0; // 0000 0000 0000 0000
		int d = ~c;// 1111 1111 1111 1111
		System.out.println(d);
		
		// shift ������ : <<left shift >>right shift >>>logical right shift
		c = 1; // 0000 0000 0000 0001
		d = c<<2; // 0000 0000 0000 0100
		System.out.println(d);
		d = d>>1; // 0000 0000 0000 0010
		System.out.println(d);
		
		c = -1; // 1111 1111 1111 1111
		d = c>>1; // 0111 1111 1111 1111�� �̵� ��, ����ִ� �� ���ڸ��� ���� ��ȣ�� �ٽ� ����
		System.out.println(d);
		d = c>>>1; // 0111 1111 1111 1111�� �̵� �� ��. ����ִ� �Ϳ� �Ű� x
		System.out.println(d); // 16�ڸ��� ǥ���� �� �ִ� ���� ū ��
		
		c = -1; // 1111 1111 1111 1111
		c = c << 1; // 1111 1111 1111 1110
		System.out.println(c);
		c = c << 1; // 1111 1111 1111 1100
		System.out.println(c);
		
	}
	

}
