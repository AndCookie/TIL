import java.util.Scanner;

/*[문제-7] 세 과목의 점수를 입력 받아 합격/불합격여부 판별하기(과락 있음)
국어, 영어, 수학의 점수를 입력.
영어는 반드시 80점 이상이어야 통과하고, 평균은 반드시 70점 이상이어야 한다.
한 과목이라도 50점 미만인 경우는 과락으로 불합격.
평균과 합격 여부를 출력하시오
 */
public class Exam7 {

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
		
		mean = (kor + eng + math)/3.0;
		result = (kor>=50 && eng>=80 && math>=50 && mean>=70) ? "합격" : "불합격";
		
		System.out.printf("평균 점수 : %.2f%n" + mean);
		System.out.println("합격 여부 : " + result);
		
		keyin.close();

	}

}
