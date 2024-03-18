package poly;

// abstract Ŭ������ ��ü�� ������ �� ���� Ŭ���� -> ��� ���� Ŭ����!!!!
abstract class AA {
	abstract void methodAA(); // ��ȣ{}
}


class BB extends AA {
	// The type BB must implement the inherited abstract method AA.methodAA()
	// BB�� ��ȣ ����θ� abstract �߻� Ŭ������ �ȴٴ� ��� �޼��� -> override�ؼ� ��ȣ ä��� 
	@Override
	void methodAA() {
		System.out.println("BBŬ������ �޼ҵ��Դϴ�.");
	}
}

class CC extends AA{
	@Override
	void methodAA() {
		System.out.println("CCŬ������ �޼ҵ��Դϴ�.");
	}
	
}

// �ڽ� Ŭ������ BB�� CC�� ���� ���� �����̸�,
// ������ �ٸ����� ������ ����� �޼ҵ带 �����ϰ� �ִ� (sysout **Ŭ������ �޼ҵ��Դϴ�)



public class PolyTest {
	public static void main(String[] args) {
		BB b = new BB();
		CC c = new CC();
		
		output(b);
		output(c);
	}
	
	// b,c �ڽ��� ������ a �ƹ����� �޴´�
	private static void output(AA a) {
		a.methodAA(); // ���� ���ε�
		// �θ��� ���� abstract�̶� �������� ���ϴ� ���, �����ϴ� ������ �ڽ� ��ü�� ������ ������
		// �θ��� ���� �����ϱ� ���� �ٿ�ĳ������ ���� �ʾƵ� �˾Ƽ� ��� �ڽ��� ���� �� ��
	}
	
	//
	
}
