/*
 * 1~127까지 코드에 해당하는 문자를 함께 출력하시오
 * 5개 출력시 줄바꿈
 * 97:a  98:b  99:c
 * (char) i
 * 
 */
public class ForTest2 {

	public static void main(String[] args) {
		System.out.println((int)('\n')); // 10 // 줄바꿈
		System.out.println((int)('\r')); // 13 // carriage return
		System.out.println((int)('\t')); // 9

		for (int i=1; i<=127; ++i) {
			System.out.print(i + ":" + (char)i + "\t");
			if (i%5==0) System.out.println();
		}

	}

}

// 10
// 13
// 32 : space
// 48 : 0