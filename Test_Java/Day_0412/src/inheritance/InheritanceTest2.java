package inheritance;


//모든 클래스는 생성자가 있어야합니다. 
class Parent2 {
//	int age; // default 접근 지정자 = 접근지정자가 없으면 "package 접근 지정자"라고 한다.
	private int age;
	
	// 자식을 위해 부모의 생성자를 생략하지 않고 직접 만들어주는 것이 낫다..
//	public Parent2() {} // JVM이 자동으로 기본 생성자를 만들어주므로 생략 가능하나 자식을 위해 만들어주는 게 낫다
//	public Parent2(int age) {
//		this.age = age;
//	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void output() {
		System.out.println("나이는 : " + age); // this.age
	}
	
	// alt+s : override/implement 클릭
	@Override
	public String toString() {
		return "age = " + this.age;
	}
	
	
}



class Child2 extends Parent2 {
	// private int age는 상속받지 못하지만 getAge라는 통로를 통해서 age에 우회 접근 가능
	private String name;
	
//	public Child2(int age, String name) { // 생성자
//		super(age); // 부모의 생성자를 호출 // 생성자의 가장 상단에 와야함 // 생략도 가능
//		this.name = name;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// Override 오버라이드 : 부모로부터 상속받은 메소드명부더 앞의 시그니처까지 전부 다 동일한 경우
	// 상속받은 메소드의 기능을 확장시 사용하는 기능 // 아버지 메소드는 가려진다..
	@Override // JVM 자바 가상머신에 오버라이드 되었음을 알려주는 것
	public void output() {
		super.output(); // 아버지 것 호출
		System.out.println("이름은 : " + this.name);
	}
	// 2개의 멤버변수 : 상속받지않고 우회해서 가져온 age와 name
	// 2개의 매서드 : 상속받지않은 자기자신의 output과 print
}



public class InheritanceTest2 {
	public static void main(String[] args) {
		// 아버지부터 객체 생성 및 실행
		Parent2 p = new Parent2(); // p는 위치값을 갖고 있는 변수 ex) stack(100번지 p박스) & heap(~데이터 100박스)
//		p.age = 50; // private은 대입 연산자 사용 불가하며 setter, getter가 필수
		p.setAge(50);
//		p.output();
		
		System.out.println(p); // 해쉬주소 출력 : 해킹 위험이 있으므로 진짜 주소는 알고리즘으로 가리는 것
		// 해시주소 출력 성공시 -> 메모리에 올라왔음을 확인 가능
//		Child2 temp; // 아직 메모리에 안올린 것의 예시
//		System.out.println(temp); // 해쉬주소 출력 불가능하므로 메모리에 안올라왔음을 확인 가능
		System.out.println(p.toString()); // 객체가 오면 자동으로 toString을 붙여주므로 주소 결과값은 동일
		// 부모 클래스에서 toString을 override하면 주소값이 아닌 실제값 출력 가능

		Child2 c = new Child2();
		// 여기까지만 실행하더라도 아버지의 코드도 같이 실행됨
		c.setAge(25);
		c.setName("홍길동");
//		c.output();

	}

}
