import java.util.Scanner;

public class OperatorTest1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		double height = 0; // 초기화
		
		System.out.print("키를 입력하세요 : ");
		height = keyin.nextDouble();
		
		// 160 ~ 170 사이인지 확인
		if ((height >= 160) && (height <= 170)) {
			System.out.println("키가 160~170입니다.");
		}
		
		System.out.println("끝!");
		
		
		
		keyin.close();
	}

}
