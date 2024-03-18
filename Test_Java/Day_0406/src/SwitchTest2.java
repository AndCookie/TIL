import java.util.Scanner;

public class SwitchTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int score; // 0~100 사이인 지 확인 후, 아닐시 종료 (return)
		String result;
		
		System.out.print("점수 입력 : ");
		score = keyin.nextInt();
		
		if (!(score>=0) && (score<=100)) {
			System.out.println("데이터를 다시 입력하세요");
			keyin.close();
			return;
		}
		
		// 90점대:A, 80:B, 70:C, 60:D, 나머지:F
		
		switch(score/10) {
		case 10 :
		case 9 : result = "A"; break;
		case 8 : result = "B"; break;
		case 7 : result = "C"; break;
		case 6 : result = "D"; break;
		default : result = "F"; break;
		}
		
		System.out.println("결과 : " + result);

		keyin.close();
	}

}
