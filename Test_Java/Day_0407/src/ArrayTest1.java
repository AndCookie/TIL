import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		//=============== 변수 ===============
		int a; // 선언 (4byte의 메모리 공간이 할당됨)
		a = 10; // 초기화
		System.out.println(a);
		
		//=============== 배열 ================
		
		//===============1
		int [] arr; // 참조변수 선언 (4byte + 4byte*10개 = 총 44byte의 메모리 공간이 할당됨)
		arr = new int[10]; // 생성 (0으로 자동으로 초기화됨)
		arr[9]=7;
		
		//===============2
		int [] arr2 = new int[10]; // 선언과 생성을 동시에
		//  4byte   = 4byte * 10
		//          = arr2의 0번방~9번방
		arr2[0]=2;

		//===============3
		int [] arr3 = new int[] {1,2,3,4,5}; // 선언, 생성, 대입을 동시에
		// 0번방~4번방의 총 5개의 방에 1~5가 대입
		System.out.println(arr3[2]);
		
		//===============4
		int [] arr4 = {1,2,3,4,5}; // 선언, 생성, 대입을 동시에
		System.out.println(arr4[2]);
		// 없는 방 호출시 오류 발생 : ArrayindexOutOfBoundsException
		
		//===============5
		Scanner keyin = new Scanner(System.in);
		int [] arr5 = new int[5];
		System.out.println("방 개수: " + arr5.length); //방의 개수 .length
		
		for (int i=0; i<arr5.length; ++i) {
			System.out.print("arr5[" + i + "] =>");
			arr5[i] = keyin.nextInt(); // 입력 받아 초기화
		}
		
		//===============6 출력
		for (int i=0; i<arr5.length; ++i) {
			System.out.print("arr5[" + i + "] => " + arr5[i]);
			System.out.println();
		}
		
		keyin.close();
	}

}
