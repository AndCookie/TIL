package Fitness;
// class row 가로로 묶인 정보들
//public class Fitness {
//	int id;
//	String name;
//	double height;
//	double weight;
//	double bmi;
//}


// --------------설계도-----------------
// PRIVATE이 붙는 순간 5개의 SETTER와 GETTER를 생성해야 함
public class Fitness {
	private int id;
	private String name;
	private double height;
	private double weight;
	private double bmi;
	
	// SETTER
	public void setId(int id) {
		this.id = id; // this.id는 멤버변수 // id는 지역변수
		// 만약 setId(int i) {id=i}로 작성한다면 이때의 id는 멤버변수이다
		// id의 경우 int id로 지역변수 선언한 것이 아니므로 자연스럽게 위의 멤버변수를 의미하게 됨
		// 멤버변수에 마음대로 접근이 가능한 것
		// 만약 setId(int id) {id=id}로 작성한다면 이때의 id는 지역변수이다
		// 해당 지역에서는 멤버변수보다 지역변수가 더 우선순위이기 때문
		// 만약 setId(int id) {this.id}로 작성한다면 이때의 id는 멤버변수이다
		// 우리 멤버 id라는 의미
		// => 안에서는 hong, 밖에서는 this로 불리는 것
		// static은 this라고 하지 않는다! 나의 멤버가 아니다!
	}		
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBmi(); // 키와 몸무게가 바뀌었을 때 bmi도 바뀌어야 하기 때문에 호출하는 것
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcBmi();
	}
	// 외부에서 bmi를 막 바꿀 수 있으므로 만들지 않는 것이 좋다
//	public void setBmi(double bmi) {
//		this.bmi = bmi;
//	}
	// PRIVATE
	private void calcBmi() {
		bmi = weight / ((height*0.01 ) * (height*0.01 ));
		// this 생략해도 어차피 멤버변수임
		// 아래의 getBmi() {
//			bmi = weight / ((height*0.01 ) * (height*0.01 ));
//			return this.bmi; }로 설정하면,
//			getBmi()를 하기 전까지는 bmi가 업데이트되지 않는다.
	}
	
	// GETTER
	public int getId() {
		return this.id; // 여기서 id는 멤버변수 
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
//	public static void output(Fitness f) { // static은 우리 멤버가 될 수 없으므로 삭제해야	
	public void output() {
		// main이 static이므로 여기도 static해야 호출 가능
		System.out.println("회원 ID : " + id);
		System.out.println("회원이름 : " + name);
		System.out.println("몸무게(Kg) : " + weight);
		System.out.println("키(cm) : " + height);
		System.out.println("BMI : " + bmi);
	}

	
}

