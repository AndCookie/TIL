package vo;


public class Fitness {
	// 멤버변수
	private String id; // 회원아이디(문자열:연산하지 않으므로 숫자 대신 문자)
	private String name; // 회원이름(문자열)
	private double height; // 키(실수)
	private double weight; // 몸무게(실수)
	private double bmi; // bmi (실수)
	
	// 기본 생성자
	public Fitness() {
		super();
	}
	// 오버로드된 생성자
	public Fitness(String id, String name, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		calcBmi(); // 키와 몸무게가 세팅, 즉 변경되면 업데이트 되어야 함
	}
	


	// getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBmi();
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcBmi();
	}
	public double getBmi() {
		return bmi;
	}
	private void calcBmi() {
		this.bmi = weight / ((height*0.01)*(height*0.01));
	}
	
	// toString
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("id=").append(id)
		.append(", name").append(name)
		.append(", height=").append(height)
		.append(", weight=").append(weight)
		.append(", bmi=").append(bmi);
		
		return buf.toString();	
	}
	
}

