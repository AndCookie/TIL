/*
 * ���� : Ű�� �����Ը� �̿��Ͽ� BMI ���ϱ�
 * 
 */
public class OperatorTest2 {

	public static void main(String[] args) {
		String name = "ȫ�浿";
		double height = 175.5;
		double weight = 69.7;
		double temp = height/100;
		double bmi = weight / (temp*temp);
		// double bim = weight/((height/100)*(height/100));
		
		System.out.printf("%s��, Ű�� %.1fcm, ������ %.1fkg, BMI�� %.2f�Դϴ�.", name, height, weight, bmi);
//		System.out.printf("%s��, ", name);
//		System.out.printf("Ű�� %.2f cm, ", height);
//		System.out.printf("�����Դ� %.2f, ", weight);
//		System.out.printf("BMI�� %.2f �Դϴ�.", weight/(height/100)/(height/100));
		// System.out.printf("BMI�� %.2f �Դϴ�.", weight/((height/100)*(height/100)));
		// height/100 => double/int => double
		// ���� 175/100 => int/int => int (double�� �ƴϹǷ� �Ҽ���x)
	}

}
