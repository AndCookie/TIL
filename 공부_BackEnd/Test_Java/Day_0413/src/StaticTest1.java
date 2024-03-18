class MyStatic { // concrete class이므로 반드시 객체를 생성해야 쓸 수 있다
	// 일반 멤버
	// 편의상 private 생략하겠음
	int data1;
	
	// 생성자
	public MyStatic(int data1) {
		// 기본 생성자 아님. 외부에서 데이터를 받아서 초기화 해준 것
		this.data1 = data1;
	}
}


public class StaticTest1 {

	public static void main(String[] args) {
		MyStatic s = new MyStatic(15); // data1이 15라는 값으로 초기화
		System.out.println("결과: " + s.data1);
	}

}
