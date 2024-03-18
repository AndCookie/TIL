import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int egg; // 5~7g 이상이면 판매. 5미만은 판매불가, 7초과도 판매불가
		
		System.out.print("달걀 무게 입력 : ");
		egg = keyin.nextInt();
		
		if (egg>=5 && egg<=7)
			System.out.println("판매가능");
		else
			System.out.println("판매불가능");	
		
		keyin.close();

	}

}
