
public class BitTest1 {

	public static void main(String[] args) {
		int a = 2147483647;
//		System.out.println(a+1);
		int b = 0xffffffff; //4byte : f 8개 : 전체 비트를 1로 채울 수 있음
//		System.out.println(b);
		
		// ~ (1의 보수 연산자: 1's complement: 단항연산자)
		int c = 0; // 0000 0000 0000 0000
		int d = ~c;// 1111 1111 1111 1111
		System.out.println(d);
		
		// shift 연산자 : <<left shift >>right shift >>>logical right shift
		c = 1; // 0000 0000 0000 0001
		d = c<<2; // 0000 0000 0000 0100
		System.out.println(d);
		d = d>>1; // 0000 0000 0000 0010
		System.out.println(d);
		
		c = -1; // 1111 1111 1111 1111
		d = c>>1; // 0111 1111 1111 1111로 이동 후, 비어있는 맨 앞자리에 원래 부호를 다시 붙임
		System.out.println(d);
		d = c>>>1; // 0111 1111 1111 1111로 이동 후 끝. 비어있는 것에 신경 x
		System.out.println(d); // 16자리로 표현할 수 있는 가장 큰 값
		
		c = -1; // 1111 1111 1111 1111
		c = c << 1; // 1111 1111 1111 1110
		System.out.println(c);
		c = c << 1; // 1111 1111 1111 1100
		System.out.println(c);
		
	}
	

}
