
public class Exam2 {

	public static void main(String[] args) {
		int [] arr = {5, 1, 9, 3, 22, 7, 10, 15, 8, 2};
		
		
		// ���
		System.out.println("** ����");
		for (int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// �������� - ��������
		int temp;
//		if (arr[0] > arr[1]) {
//			temp = arr[0];
//			arr[0] = arr[1];
//			arr[1] = temp;
//		}
//		if (arr[1] > arr[2]) {
//			temp = arr[1];
//			arr[1] = arr[2];
//			arr[2] = temp;
//		}
		for (int i=0; i<arr.length-1; ++i) {
			for (int j=0; j<arr.length-1-i; ++j) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("** �������� ��������");
		for (int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		

	}

}
