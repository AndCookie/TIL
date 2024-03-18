/*
 * 문제 : 키와 몸무게를 이용하여 BMI 구하기
 * 
 */
public class OperatorTest2 {

	public static void main(String[] args) {
		String name = "홍길동";
		double height = 175.5;
		double weight = 69.7;
		double temp = height/100;
		double bmi = weight / (temp*temp);
		// double bim = weight/((height/100)*(height/100));
		
		System.out.printf("%s님, 키는 %.1fcm, 몸무게 %.1fkg, BMI는 %.2f입니다.", name, height, weight, bmi);
//		System.out.printf("%s님, ", name);
//		System.out.printf("키는 %.2f cm, ", height);
//		System.out.printf("몸무게는 %.2f, ", weight);
//		System.out.printf("BMI는 %.2f 입니다.", weight/(height/100)/(height/100));
		// System.out.printf("BMI는 %.2f 입니다.", weight/((height/100)*(height/100)));
		// height/100 => double/int => double
		// 만약 175/100 => int/int => int (double이 아니므로 소수점x)
	}

}
