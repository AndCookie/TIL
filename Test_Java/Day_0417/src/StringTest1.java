
public class StringTest1 {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String str1 = "Korea";
		String str2 = new String("대한민국");
		
		byte[] by1 = new byte[10];
		by1[0] = 1;
		
		byte[] by2 = {65,66,67,68};
		String str3 = new String(by2);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
 
	}

}
