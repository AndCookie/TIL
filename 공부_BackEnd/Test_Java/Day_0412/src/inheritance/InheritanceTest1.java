package inheritance;

//모든 클래스는 생성자가 있어야합니다. 
class Parent {
	int age;
	public Parent() { // 기본 생성자
		System.out.println("Parent의 생성자입니다.");
	}
	public void output() {
		System.out.println("나이는 : " + this.age);
	}
}

class Child extends Parent {
	// 5,9,10,11라인 상속 받음
	// 6,7,8라인 상속 불가 (생성자 상속x)
	String name;
	public Child() { // 생성자
		super(); // 부모의 생성자를 호출 // 생성자의 가장 상단에 와야함 // 생략도 가능
		System.out.println("Child의 생성자입니다.");
	}
	public void print() {
//		super.output(); // 부모의 것
		this.output(); // 자식의 것
		// 여기서는 부모의 것이 자식의 것이므로 어떤 것을 하든 결과 동일
		System.out.println("이름은 : " + this.name);
	}
	// 2개의 멤버변수 : 상속받은 age와 name
	// 2개의 매서드 : 상속받은 output과 print
}



public class InheritanceTest1 {
	public static void main(String[] args) {
		// 아버지부터 객체 생성 및 실행
		Parent p = new Parent();
		p.age = 50;
		p.output();

		Child c = new Child();
		// 여기까지만 실행하더라도 아버지의 코드도 같이 실행됨
		c.age = 25;
		c.name = "홍길동";
//		c.output();
		c.print();
	}

}
