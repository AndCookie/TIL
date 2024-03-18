package vo;

public class Fitness {
	private String id;		// 아이디
	private String name;	// 회원이름
	private double height;	// 키
	private double weight;	// 몸무게
	private double bmi;		// bmi
	public Fitness() {
		super();
	}
	public Fitness(String id, String name, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		calcBmi();
	}
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
		this.bmi = weight / ((height*0.01) *(height*0.01));
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", bmi=" + bmi;
	}
}
