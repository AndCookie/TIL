import java.util.Scanner;

/*
 * [문제4]
달걀의 무게를 반복적으로 입력 받는다.
5~7g만 출하가 가능한 달걀이다.
5개가 패킹이 완료되면 종료한다. 
 */
public class Exam4 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int i = 0;
		double weight=0;
		
		
		while (true) {
			System.out.println("달걀 무게 입력 : ");
			weight = keyin.nextDouble();
			if ((weight>=5) && (weight<=7)) {
				++i;
				System.out.println(i + "개 포장");
			} else System.out.println("포장 불가");
			
			if (i==5) break;
		}
		System.out.println("5개 패킹이 완료되었습니다!");	
		System.out.println("** 1팩 출하");	
		keyin.close();
	}
}