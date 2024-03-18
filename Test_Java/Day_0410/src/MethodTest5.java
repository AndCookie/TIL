
public class MethodTest5 {

	public static void main(String[] args) {
		int[] arr = {10, 20}; // 참조형 변수
		// arr에 100, heap에 10,20이 생성되고 주소가 각각 111,222라면 메모리상의 arr이 참조하는 각 1,2번방이 되는 것
		System.out.println("호출 전");
		System.out.println("arr[0] = " + arr[0] + ", arr[1] = " + arr[1]);
		
		exchange(arr); // Call by reference (참조값에 의한 호출 : 원본 접근 가능)
		System.out.println("호출 후");
		System.out.println("arr[0] = " + arr[0] + ", arr[1] = " + arr[1]);
		// 배열로 받으면, 참조되는 위치값을 받게 되므로 원본에 접근 가능하다
	}
	
	public static void exchange(int[] b) {
		// 배열로 선언되었으므로 배열로 받는 것
		// main에서 arr이 int로 선언되었으므로 매개변수를  int[] b로 적은 것
		// main의 매개변수가 string 문자열이기 때문에 가능한 것
		// b는 주소값인 100, heap의 10과 20을 받는 것
		int temp;
		temp = b[0];
		b[0] = b[1];
		b[1] = temp;	
	}

}
