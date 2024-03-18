import java.util.Scanner;

public class InputTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //  자동  import : ctrl + shift + o
		
		// 변수 선언
		double radius, area;
		final double pi = 3.141592;
		
		// 데이터 준비
		System.out.print("반지름 x를 입력 : ");
		radius = scanner.nextDouble();
		
		// 연산
		area = pi * (radius * radius);
		
		// 출력
		System.out.printf("반지름 %.2f인 원의 면적은 %.2f입니다.", radius, area);
		
		scanner.close(); // 한 번 닫으면 끝나므로 가장 마지막 단계에 입력해야함
	}

}
