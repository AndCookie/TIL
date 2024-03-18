package net.kd.school.vo;

public class ScoreVO {
	private String stnum;			//학생 구분번호
	private int java;				//java과목 점수
	private int sql;				//sql과목 점수
	private int spring;				//spring과목 점수

	public ScoreVO() {
	}
	

	public ScoreVO(String stnum, int java, int sql, int spring) {
		super();
		this.stnum = stnum;
		this.java = java;
		this.sql = sql;
		this.spring = spring;
	}

	public String getStnum() {
		return stnum;
	}

	public void setStnum(String stnum) {
		this.stnum = stnum;
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


	@Override
	public String toString() {
		return "ScoreVO [stnum=" + stnum + ", java=" + java + ", sql=" + sql + ", spring=" + spring
				+ "]";
	}
}
