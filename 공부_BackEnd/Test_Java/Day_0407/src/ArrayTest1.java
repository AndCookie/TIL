import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		//=============== ���� ===============
		int a; // ���� (4byte�� �޸� ������ �Ҵ��)
		a = 10; // �ʱ�ȭ
		System.out.println(a);
		
		//=============== �迭 ================
		
		//===============1
		int [] arr; // �������� ���� (4byte + 4byte*10�� = �� 44byte�� �޸� ������ �Ҵ��)
		arr = new int[10]; // ���� (0���� �ڵ����� �ʱ�ȭ��)
		arr[9]=7;
		
		//===============2
		int [] arr2 = new int[10]; // ����� ������ ���ÿ�
		//  4byte   = 4byte * 10
		//          = arr2�� 0����~9����
		arr2[0]=2;

		//===============3
		int [] arr3 = new int[] {1,2,3,4,5}; // ����, ����, ������ ���ÿ�
		// 0����~4������ �� 5���� �濡 1~5�� ����
		System.out.println(arr3[2]);
		
		//===============4
		int [] arr4 = {1,2,3,4,5}; // ����, ����, ������ ���ÿ�
		System.out.println(arr4[2]);
		// ���� �� ȣ��� ���� �߻� : ArrayindexOutOfBoundsException
		
		//===============5
		Scanner keyin = new Scanner(System.in);
		int [] arr5 = new int[5];
		System.out.println("�� ����: " + arr5.length); //���� ���� .length
		
		for (int i=0; i<arr5.length; ++i) {
			System.out.print("arr5[" + i + "] =>");
			arr5[i] = keyin.nextInt(); // �Է� �޾� �ʱ�ȭ
		}
		
		//===============6 ���
		for (int i=0; i<arr5.length; ++i) {
			System.out.print("arr5[" + i + "] => " + arr5[i]);
			System.out.println();
		}
		
		keyin.close();
	}

}
