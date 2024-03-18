class Person {
	// 멤버변수
	private String name;
	private int age;
	
	// 생성자
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// toString : 문자열로 변환해주는 역할
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	// equals : 다형성을 적용한 equals
	@Override
	public boolean equals(Object obj) {
//		this
		// this는 p1 : 호출한 놈 : Person 타입 // obj는 p2 : Object 타입
		// 전달인자를 Object로 받다보니 서로의 타입이 달라 비교가 불가능
		// 따라서 p2를 Object타입에서 Person 타입으로  다운캐스팅 해야함
		// 그런데 만약 p2가 아니라 obj를 전달인자로 넣는다면?
		// Person타입으로 다운캐스팅 변환 불가능,,
		// 따라서 instanceof 연산자로 어디를 가리키고 있는지 확인해야한다
		
		Person temp = null; // if문 밖에서 사용하려면 미리 선언해둬야 하니까 :)
		if (obj instanceof Person) {
			temp = (Person)(obj); // 다운캐스팅 // this ==> p1, temp ==> p2
			// 다운캐스팅이 끝난 후에 각 요소가 같은지 비교해야함
			if (this.name.equals(temp.name) && // 문자열 비교는 equals
					this.age == temp.age) // int 비교는 비교연산자 ==
			return true;
			else
				return false;
		} else {
			return false;
		}
	}


	// JVM이 만들어주는 것
//	@Override
//	public int hashCode() {
//		해시코드 오버라이딩시 p1과 p2가 같은 주소를 공유하여 바라보게 만드므로 주석 처리하여 쓰지 않겠다
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) // this ==> p1 // obj == > p2
//			return true;
//		if (obj == null) // 전달인자가 null인 경우
//			return false;
//		if (getClass() != obj.getClass()) // 타입이 다른 경우
//			return false;
//		Person other = (Person) obj; // 다운캐스팅
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
}



public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 25);
		Person p2 = new Person("홍길동", 25);
		
		
		// Person 타입을 만들 때 equals라는 메소드를 만든 적이 없지만
		// Object 조상 클래스로부터 상속받은 메소드라서 오류 발생하지 않는 것
		System.out.println(p1 == p2); // FALSE : p1과 p2의 주소값은 다름
		System.out.println(p1.equals(p2));
		// FALSE : object로부터 상속받은 equals는  Person에 맞지 않는 것.. 따라서 비교 불가
		// 전달인자인 Object obj는 부모클래스, 자식클래스 모두 받을 수 있기 때문에 비교 불가
		// 따라서 equals 메소드를 Override 해줘야 함
		
		System.out.println(p1.toString());
		// 위에 toString을 오버라이드 하지 않으면 해쉬주소가 출력됨
		// toString을 오버라이드 한 후에나 실제 값이 출력됨
		
	}

}
