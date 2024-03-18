package net.kd.school.vo;

//학생 정보
public class StudentVO {
	private String stnum;				//학생 구분번호
	private String stclass;				//반
	private String stname;				//이름
		
	public StudentVO() {
	}

	public StudentVO(String stnum, String stclass, String stname) {
		super();
		this.stnum = stnum;
		this.stclass = stclass;
		this.stname = stname;
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

	@Override
	public String toString() {
		return "학번=" + stnum + ", 반=" + stclass + ", 이름=" + stname ;
	}
}
