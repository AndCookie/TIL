package Score;
// main이 있어야 실행 가능

public class Score {
	private String name; // 멤버변수 = 인스턴스 변수
	private int kor;
	private int mat;
	private int eng;
	private double avg;	
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	// getter
	public String getName() {
		return this.name;
	}
	public int getKor() {
		return this.kor;
	}
	public int getMat() {
		return this.mat;
	}
	public int getEng() {
		return this.eng;
	}
	public double getAvg() {
		return this.avg;
	}
	
	
	
	
}
