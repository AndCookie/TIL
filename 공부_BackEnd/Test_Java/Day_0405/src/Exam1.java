import java.util.Scanner;
/* [문제]
 * 나이가 6세 미만이거나 65세 초과이면
 * 5% 할인
 * 
 */
public class Exam1 {

	public static void main(String[] args) {
		final int price = 25000;
		int age = 0;
		int fee;
		double discount;
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		
		System.out.print("나이를 입력하세요 : ");
		age = keyin.nextInt();
		
		discount = (age<6 || age>65) ? 0.05 : 0;
		System.out.println("할인율은 " + discount);
		fee = (int) (price*(1-discount));
		
//		if ((age<6) || (age>65)) {
//			fee = (int) (price * 0.95);
//			// 1. 멈춰
//			// System.out.println("요금은" + fee + "입니다.");
//			// return; // 호출했던 쪽으로 다시 되돌아가리는 의미
//			// 2. elif
//		} else {
//			fee = price;
//		}
		System.out.println("요금은 " + fee + "원 입니다.");
		keyin.close();
		
	}

}
