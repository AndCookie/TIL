package vo;


public class Fitness {
	// �������
	private String id; // ȸ�����̵�(���ڿ�:�������� �����Ƿ� ���� ��� ����)
	private String name; // ȸ���̸�(���ڿ�)
	private double height; // Ű(�Ǽ�)
	private double weight; // ������(�Ǽ�)
	private double bmi; // bmi (�Ǽ�)
	
	// �⺻ ������
	public Fitness() {
		super();
	}
	// �����ε�� ������
	public Fitness(String id, String name, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		calcBmi(); // Ű�� �����԰� ����, �� ����Ǹ� ������Ʈ �Ǿ�� ��
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

