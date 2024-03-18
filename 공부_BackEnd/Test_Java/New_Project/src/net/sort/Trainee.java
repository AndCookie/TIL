package net.sort;

public class Trainee {
	private String name;
	private int kor, eng, mat;
	private double avg;
	private int rank;
	
	public Trainee() {}
	public Trainee(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.avg = (this.kor + this.eng + this.mat)/3.0;
	}
	
	// setter / getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		String temp = String.format("%-5s \t %4d %4d %4d %7.2f %3d위",
				name, kor, eng, mat, avg, rank);
		// -는 왼쪽정렬
		return temp;
	}
}