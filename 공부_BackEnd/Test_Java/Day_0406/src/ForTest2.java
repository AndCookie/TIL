/*
 * 1~127���� �ڵ忡 �ش��ϴ� ���ڸ� �Բ� ����Ͻÿ�
 * 5�� ��½� �ٹٲ�
 * 97:a  98:b  99:c
 * (char) i
 * 
 */
public class ForTest2 {

	public static void main(String[] args) {
		System.out.println((int)('\n')); // 10 // �ٹٲ�
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