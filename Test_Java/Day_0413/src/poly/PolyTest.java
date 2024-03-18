package poly;

// abstract 클래스는 객체를 생성할 수 없는 클래스 -> 상속 전용 클래스!!!!
abstract class AA {
	abstract void methodAA(); // 괄호{}
}


class BB extends AA {
	// The type BB must implement the inherited abstract method AA.methodAA()
	// BB도 괄호 비워두면 abstract 추상 클래스가 된다는 경고 메세지 -> override해서 괄호 채우기 
	@Override
	void methodAA() {
		System.out.println("BB클래스의 메소드입니다.");
	}
}

class CC extends AA{
	@Override
	void methodAA() {
		System.out.println("CC클래스의 메소드입니다.");
	}
	
}

// 자식 클래스인 BB와 CC는 서로 형제 관계이며,
// 내용은 다르지만 형식이 비슷한 메소드를 공유하고 있다 (sysout **클래스의 메소드입니다)



public class PolyTest {
	public static void main(String[] args) {
		BB b = new BB();
		CC c = new CC();
		
		output(b);
		output(c);
	}
	
	// b,c 자식을 던지면 a 아버지가 받는다
	private static void output(AA a) {
		a.methodAA(); // 동적 바인딩
		// 부모의 것이 abstract이라 실행하지 못하는 경우, 실행하는 시점의 자식 객체의 것으로 수행함
		// 부모의 것이 없으니까 따로 다운캐스팅을 하지 않아도 알아서 모든 자식의 것을 다 씀
	}
	
	//
	
}
