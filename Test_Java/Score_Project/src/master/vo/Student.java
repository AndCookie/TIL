package master.vo;

public class Student {
	private String stdid;
	private String stdname;
	private double it;
	private double language;
	private double basic;
	private double avg;
	private String grade;

	
	// 기본 생성자
	public Student() {
		super();
	}
	// 오버로드된 생성자
	public Student(String stdid, String stdname, double it, double language, double basic) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.it = it;
		this.language = language;
		this.basic = basic;
		calcAvg();
		calcGrade();
	}
	
	// setter, getter	
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public double getIt() {
		return it;
	}
	public void setIt(double it) {
		this.it = it;
		calcAvg();
		calcGrade();
	}
	public double getLanguage() {
		return language;
	}
	public void setLanguage(double language) {
		this.language = language;
		calcAvg();
		calcGrade();
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
		calcAvg();
		calcGrade();
	}
	public double getAvg() {
		return avg;
	}
	public String getGrade() {
		return grade;
	}

	
	// 일반 메소드
	// calcAvg() 평균 계산
	private void calcAvg() {
		this.avg = it*0.4 + language*0.3 + basic*0.3;
	}
	// check Grade() 등급 계산
	private void calcGrade() {
		if (avg>=90) this.grade = "1등급";
		else if (avg>=80) this.grade = "2등급";
		else if (avg>=70) this.grade = "3등급";
		else if (avg>=60) this.grade = "4등급";
		else this.grade = "5등급";
	}
	
	
	// toString()
	@Override
	public String toString() {
		String temp = String.format("%3s %5s : %7.2f %7.2f %7.2f %7.2f %s",
				stdid, stdname, it, language, basic, avg, grade);
		return temp;
	}
	
	
}
