
public class MethodTest4 {

	public static void main(String[] args) {
		int a =10, b=20;
		System.out.println("호출 전");
		System.out.println("a = " + a + ", b = " + b);
		
		exchange(a, b); // Call by value (값에 의한 호출)
		System.out.println("호출 후");
		System.out.println("a = " + a + ", b = " + b);
	}
	
	public static void exchange(int a, int b) {
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
		// 여기서 a, b, temp는 지역변수임!!!
		// 따라서 10과 20을 전달 받은 후 exchange하여 20과 10이 되는데
		// 메모리 상에서 지역변수를 지워버리기 때문에
		// 내부적으로만 exchange되고 밖에서는 exchange된 것을 확인할 수 없는 것
		// main의 ab와 exchange의 ab 간의 주소값은 서로 다름	
	}

}
