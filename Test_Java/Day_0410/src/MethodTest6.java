
public class MethodTest6 {

	public static void main(String[] args) {
		double[] ary = myMethod();
		System.out.println(ary); // 주소값이 나옴 (100번지)
		System.out.println(ary[0]);
		System.out.println(ary[1]);
		
		String data = yourMethod();
		yourMethod(); // ''char(기본자료형), "" String(객체)
		System.out.println(data);
	}
	
	public static double[] myMethod() {
		// main이 static이므로 여기도 static해야 호출 가능
		double[] ary = {1.2, 3.4}; // 초기화
		return ary;
	}
	
	public static String yourMethod() {
		return "Hello world!";
	}

}
