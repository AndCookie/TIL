import java.util.Scanner;

public class BupperTest1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int a;
		double b;
		String c, d;
		
		System.out.println("정수 3개 입력: ");
		a = keyin.nextInt();
		b = keyin.nextDouble();
		c = keyin.next();
		d = keyin.nextLine(); // 한 줄 전체를 가져옴
		System.out.println(a + ", " + b + ", " + c + ", " + d);
		
		keyin.close();

	}

}
