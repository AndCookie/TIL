/*
 * [����]
 * �Ʒ��� ���� ���ڿ� �迭�� ���� ��
 * �� �л��� ���� �հ�� ����� ���Ͻÿ�
 * 
 */
public class Exam_01 {

	public static void main(String[] args) {
		String[] score = {
				"ȫ�浿 100 98.5 75.5", // split, parseDouble
				"�Ӳ��� 85.5 70.4 70.5",
				"�տ��� 75.6 88.5 72",
				"���Ȱ� 90 95.5 70.5",
				"����� 87 88.5 90.5"
		};
		
		for (int i=0; i<score.length; ++i) {
			String[] temp = score[i].split(" ");
			
			double kor = Double.parseDouble(temp[1]);
			double math = Double.parseDouble(temp[2]);
			double eng = Double.parseDouble(temp[3]);
			
			double total = kor+math+eng;
			double avg = total/3;
			
			System.out.printf("%s %6.2f %6.2f %6.2f %6.2f %6.2f%n",
					temp[0], kor, math, eng, total, avg);
		}				

	}

}
