
public class StringTest1 {

	public static void main(String[] args) {
		// ���ڿ� ��ü ����
		String str1 = "Korea";
		String str2 = new String("���ѹα�");
		
		byte[] by1 = new byte[10];
		by1[0] = 1;
		
		byte[] by2 = {65,66,67,68};
		String str3 = new String(by2);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
 
	}

}
