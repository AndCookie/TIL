package overload;

public class OverloadTest {

	public static void main(String[] args) {
		System.out.println("1) ���: " + add(10,15));
		System.out.println("2) ���: " + add(10,15,6));
		System.out.println("3) ���: " + add(10.2, 15.6));
		System.out.println("4) ���: " + add(10, 15.6));

	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	public static int add(int a, int b, int c) {
		return a+b+c;
	}
	public static double add(double a, double b) {
		return a+b;
		// 10�� ���޵Ǵ��� int�� double�� �ڵ� ���� promotion��
	}
	
}
