package Fitness;
// class row ���η� ���� ������
//public class Fitness {
//	int id;
//	String name;
//	double height;
//	double weight;
//	double bmi;
//}


// --------------���赵-----------------
// PRIVATE�� �ٴ� ���� 5���� SETTER�� GETTER�� �����ؾ� ��
public class Fitness {
	private int id;
	private String name;
	private double height;
	private double weight;
	private double bmi;
	
	// SETTER
	public void setId(int id) {
		this.id = id; // this.id�� ������� // id�� ��������
		// ���� setId(int i) {id=i}�� �ۼ��Ѵٸ� �̶��� id�� ��������̴�
		// id�� ��� int id�� �������� ������ ���� �ƴϹǷ� �ڿ������� ���� ��������� �ǹ��ϰ� ��
		// ��������� ������� ������ ������ ��
		// ���� setId(int id) {id=id}�� �ۼ��Ѵٸ� �̶��� id�� ���������̴�
		// �ش� ���������� ����������� ���������� �� �켱�����̱� ����
		// ���� setId(int id) {this.id}�� �ۼ��Ѵٸ� �̶��� id�� ��������̴�
		// �츮 ��� id��� �ǹ�
		// => �ȿ����� hong, �ۿ����� this�� �Ҹ��� ��
		// static�� this��� ���� �ʴ´�! ���� ����� �ƴϴ�!
	}		
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBmi(); // Ű�� �����԰� �ٲ���� �� bmi�� �ٲ��� �ϱ� ������ ȣ���ϴ� ��
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcBmi();
	}
	// �ܺο��� bmi�� �� �ٲ� �� �����Ƿ� ������ �ʴ� ���� ����
//	public void setBmi(double bmi) {
//		this.bmi = bmi;
//	}
	// PRIVATE
	private void calcBmi() {
		bmi = weight / ((height*0.01 ) * (height*0.01 ));
		// this �����ص� ������ ���������
		// �Ʒ��� getBmi() {
//			bmi = weight / ((height*0.01 ) * (height*0.01 ));
//			return this.bmi; }�� �����ϸ�,
//			getBmi()�� �ϱ� �������� bmi�� ������Ʈ���� �ʴ´�.
	}
	
	// GETTER
	public int getId() {
		return this.id; // ���⼭ id�� ������� 
	}
	public String getName(){
		return this.name;
	}
	public double getHeight(){
		return this.height;
	}
	public double getWeight(){
		return this.weight;
	}
	public double getBmi(){
		return this.bmi;
	}
	
	
	// output
//	public static void output(Fitness f) { // static�� �츮 ����� �� �� �����Ƿ� �����ؾ�	
	public void output() {
		// main�� static�̹Ƿ� ���⵵ static�ؾ� ȣ�� ����
		System.out.println("ȸ�� ID : " + id);
		System.out.println("ȸ���̸� : " + name);
		System.out.println("������(Kg) : " + weight);
		System.out.println("Ű(cm) : " + height);
		System.out.println("BMI : " + bmi);
	}

	
}

