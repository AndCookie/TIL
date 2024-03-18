package vo;
// 아이디(userid), 이름(username), 성별(gender)
// 전화번호(phone), 생년월일(birthday)

public class User {
	// 변수 선언
	private String userid;
	private String username;
	private String gender;
	private String phone;
	private String birthday;
	
	// 생성자
	public User( ) {
		super();
	}

	public User(String userid, String username, String gender, String phone, String birthday) {
		super();
		this.userid = userid;
		this.username = username;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	// setter, getter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", gender=" + gender + ", phone=" + phone
				+ ", birthday=" + birthday + "]";
	}
	
}
