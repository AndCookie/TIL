import java.util.Scanner;

public class SwitchTest2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int score; // 0~100 ������ �� Ȯ�� ��, �ƴҽ� ���� (return)
		String result;
		
		System.out.print("���� �Է� : ");
		score = keyin.nextInt();
		
		if (!(score>=0) && (score<=100)) {
			System.out.println("�����͸� �ٽ� �Է��ϼ���");
			keyin.close();
			return;
		}
		
		// 90����:A, 80:B, 70:C, 60:D, ������:F
		
		switch(score/10) {
		case 10 :
		case 9 : result = "A"; break;
		case 8 : result = "B"; break;
		case 7 : result = "C"; break;
		case 6 : result = "D"; break;
		default : result = "F"; break;
		}
		
		System.out.println("��� : " + result);

		keyin.close();
	}

}
