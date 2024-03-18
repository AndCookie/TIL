import java.util.Scanner;

/*[문제-6] 총점과 평균 구하기
세 과목의 점수를 입력 받아 총점과 평균을 출력하는 프로그램을 작성하시오
<실행예>
국어 점수 : 90
영어 점수 : 87
수학 점수 : 99
총점 : 276, 평균 : 92.0
 */

public class Exam6 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int kor=0, eng=0, math=0, total=0;
		double mean=0;
		String result;
		
		System.out.print("국어 점수 : ");
		kor = keyin.nextInt();
		System.out.print("영어 점수 : ");
		eng = keyin.nextInt();
		System.out.print("수학 점수 : ");
		math = keyin.nextInt();
		
		total = kor + eng + math;
		mean = total/3.0;
		
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.printf("총점: %d, 평균 :%.1f%n", total, mean);
		
		keyin.close();
	}

}
