package Score;
// ClassTest1.java --(컴파일)--> ClassTest1.class --> 실행
//							   Score.class


//// Score 클래스 정의
//// public class Score : 파일명이 같은 경우에만 public을 쓸 수 있으므로 오류 발생 
//class Score {
//	String name; // 멤버변수 = 인스턴스 변수
//	int kor;
//	int mat;
//	int eng;
//	double avg;
//}

public class ScoreTest1 {
	public static void main(String[] args) {
//		String name; // 지역변수
		
		// 다이렉트로 접근
		// 클래스를 생성해서 사용
		Score s1 = new Score(); // 생성자 매소드 (Constructor) : 메모리에 올리고 참조해라
		// heap : name . k, m, e, a
//		s1.name = "홍길동";
//		s1.kor = 100;
//		s1.eng = 98;
//		s1.mat = 88;
//		s1.avg = (s1.kor + s1.mat + s1.eng) / 3.0;
//		System.out.println(s1.name + " : " + s1.avg);
//		
		Score s2 = new Score();
//		s2.name = "임꺽정";
//		s2.kor = 87;
//		s2.eng = 89;
//		s2.mat = 70;
//		s2.avg = (s2.kor + s2.mat + s2.eng) / 3.0;
//		System.out.println(s2.name + " : " + s2.avg);
//		
		
		// 메소드를 통해서 우회적으로 접근
		s1.setName("홍길동");
		s1.setKor(100);
		s1.setEng(98);
		s1.setMat(88);
		s1.setAvg((s1.getKor()+s1.getEng()+s1.getMat())/3.0);
		System.out.println(s1.getName() + " : " + s1.getAvg());
		
		s2.setName("임꺽정");
		s2.setKor(87);
		s2.setEng(89);
		s2.setMat(70);
		s2.setAvg((s2.getKor()+s2.getEng()+s2.getMat())/3.0);
		System.out.println(s2.getName() + " : " + s2.getAvg());
		
	}
}
