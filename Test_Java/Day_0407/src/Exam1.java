/*
 * [����1]
�����迭 10���� �����ϰ� ������ ������ �ʱ�ȭ �� ����Ͻÿ�.
 */
public class Exam1 {

	public static void main(String[] args) {
		int [] arr = {10,9,8,7,6,5,4,3,2,1};
		// 9���� = arr[9] = arr[arr.length-1]
		int total = 0;
		
		for (int i=0; i<arr.length; ++i) {
			total += arr[i];
			System.out.print(arr[i] + " ");
		}
		// ======================= �迭�� ����ִ� �������� �հ踦 ���
		System.out.println("\n���� : " + total);
		
		
		// ======================= 0����� ������ ���� ������ ��ȯ
		int temp;
//		temp = arr[0];
//		arr[0] = arr[arr.length-1];
//		arr[arr.length-1] = temp;
//		
//		temp = arr[1];
//		arr[1] = arr[arr.length-2];
//		arr[arr.length-2] = temp;
//		
//		temp = arr[2];
//		arr[2] = arr[arr.length-3];
//		arr[arr.length-3] = temp;
		
		for (int i=0; i<arr.length/2; ++i) {
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		
		for (int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

}
