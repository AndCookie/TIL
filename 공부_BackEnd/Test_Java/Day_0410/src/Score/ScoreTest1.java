package Score;
// ClassTest1.java --(������)--> ClassTest1.class --> ����
//							   Score.class


//// Score Ŭ���� ����
//// public class Score : ���ϸ��� ���� ��쿡�� public�� �� �� �����Ƿ� ���� �߻� 
//class Score {
//	String name; // ������� = �ν��Ͻ� ����
//	int kor;
//	int mat;
//	int eng;
//	double avg;
//}

public class ScoreTest1 {
	public static void main(String[] args) {
//		String name; // ��������
		
		// ���̷�Ʈ�� ����
		// Ŭ������ �����ؼ� ���
		Score s1 = new Score(); // ������ �żҵ� (Constructor) : �޸𸮿� �ø��� �����ض�
		// heap : name . k, m, e, a
//		s1.name = "ȫ�浿";
//		s1.kor = 100;
//		s1.eng = 98;
//		s1.mat = 88;
//		s1.avg = (s1.kor + s1.mat + s1.eng) / 3.0;
//		System.out.println(s1.name + " : " + s1.avg);
//		
		Score s2 = new Score();
//		s2.name = "�Ӳ���";
//		s2.kor = 87;
//		s2.eng = 89;
//		s2.mat = 70;
//		s2.avg = (s2.kor + s2.mat + s2.eng) / 3.0;
//		System.out.println(s2.name + " : " + s2.avg);
//		
		
		// �޼ҵ带 ���ؼ� ��ȸ������ ����
		s1.setName("ȫ�浿");
		s1.setKor(100);
		s1.setEng(98);
		s1.setMat(88);
		s1.setAvg((s1.getKor()+s1.getEng()+s1.getMat())/3.0);
		System.out.println(s1.getName() + " : " + s1.getAvg());
		
		s2.setName("�Ӳ���");
		s2.setKor(87);
		s2.setEng(89);
		s2.setMat(70);
		s2.setAvg((s2.getKor()+s2.getEng()+s2.getMat())/3.0);
		System.out.println(s2.getName() + " : " + s2.getAvg());
		
	}
}
