import java.util.Scanner;

/*
 * [문제2] BMI 계산하고 표준 체중 알려주기
이름, 키(cm), 몸무게(kg), bmi 계산
bmi = 몸무게 / 키(m)의 제곱
표준 체중 = (키(cm)-100) * 0.9

고도 비만 : 35 이상
중(重)도 비만 (2단계 비만) : 30 - 34.9
경도 비만 (1단계 비만) : 25 - 29.9
과체중 : 23 - 24.9
정상 : 18.5 - 22.9
저체중 : 18.5 미만

<실행 예시>
name, height weight, bmi, result입력 받기
 * 
 */
public class Exam2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String name, result;
		double height=0, weight=0, bmi=0, standardweight=0;
		
		System.out.print("이름 입력 : ");
		name = keyin.next();
		System.out.print("키(cm) 입력 : ");
		height = keyin.nextDouble();
		System.out.print("몸무게(kg) 입력 : ");
		weight = keyin.nextDouble();
		
		bmi = weight / ((height/100) * (height/100));
//		if (bmi>35) result="고도 비만";
//		else if (bmi>30) result="중도 비만";
//		else if (bmi>25) result="경도 비만";
//		else if (bmi>23) result="과체중";
//		else if (bmi>18.5) result="정상";
//		else result="저체중";
		
		if (bmi<18.5) result="저체중";
		else if (bmi<23) result="정상";
		else if (bmi<25) result="과체중";
		else if (bmi<30) result="경도 비만";
		else if (bmi<35) result="중도 비만";
		else result="고도 비만";
		
		standardweight = (height-100) * 0.9;
		
		System.out.println();
		System.out.println("이름: " + name);
		System.out.println("키: " + height);
		System.out.println("몸무게: " + weight);
		System.out.printf("BMI: %.2f%n", bmi);
		System.out.println("결과: " + result);
		System.out.printf("표준체중: %.2f%n", standardweight);
		
		keyin.close();

	}

}
