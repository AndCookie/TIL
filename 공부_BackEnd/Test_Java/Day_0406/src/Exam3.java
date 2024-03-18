import java.util.Scanner;

/*
 * [문제3] 오름차순 정렬 // temp 변수 사용
정수 3개를 입력 받은 후, (같은 값은 입력하지 않음)
작은 값에서부터 순서대로 출력하기
<실행 예시>
34
15
23
결과 : 15 23 34
 * 
 * 
 */
public class Exam3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int max, min, median, temp;
		
		System.out.print("첫 번째 정수 입력 : "); max = keyin.nextInt();
		System.out.print("두 번째 정수 입력 : ");	min = keyin.nextInt();
		System.out.print("세 번째 정수 입력 : "); median = keyin.nextInt();
		
		if (max < min) {
			temp = max;
			max = min;
			min = temp;
		}
		
		if (max < median) {
			temp = max;
			max = median;
			median = temp;
		}
		
		if (median < min) {
			temp = median;
			median = min;
			min = temp;
		}
		
		System.out.println(min + " " + median + " " + max);
		
		keyin.close();
	}

}
