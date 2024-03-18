package net.kd.school.vo;

public class Total {
	private String stnum;			//학생 구분번호
	private String stclass;			//반
	private String stname;			//이름
	private int java;				//java과목 점수
	private int sql;				//sql과목 점수
	private int spring;				//spring과목 점수
	private int total;				//총점
	private double avg;				//평균
	public Total() {
		super();
	}
	public String getStnum() {
		return stnum;
	}
	public void setStnum(String stnum) {
		this.stnum = stnum;
	}
	public String getStclass() {
		return stclass;
	}
	public void setStclass(String stclass) {
		this.stclass = stclass;
	}
	
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "학번=" + stnum + ", 반=" + stclass + ", 이름=" + stname + ", Java=" + java + ", SQL="
				+ sql + ", Spring=" + spring + ", 합계=" + total + ", 평균=" + avg;
	}

	
}
