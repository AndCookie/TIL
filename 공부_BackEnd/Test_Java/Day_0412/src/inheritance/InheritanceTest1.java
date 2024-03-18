package inheritance;

//��� Ŭ������ �����ڰ� �־���մϴ�. 
class Parent {
	int age;
	public Parent() { // �⺻ ������
		System.out.println("Parent�� �������Դϴ�.");
	}
	public void output() {
		System.out.println("���̴� : " + this.age);
	}
}

class Child extends Parent {
	// 5,9,10,11���� ��� ����
	// 6,7,8���� ��� �Ұ� (������ ���x)
	String name;
	public Child() { // ������
		super(); // �θ��� �����ڸ� ȣ�� // �������� ���� ��ܿ� �;��� // ������ ����
		System.out.println("Child�� �������Դϴ�.");
	}
	public void print() {
//		super.output(); // �θ��� ��
		this.output(); // �ڽ��� ��
		// ���⼭�� �θ��� ���� �ڽ��� ���̹Ƿ� � ���� �ϵ� ��� ����
		System.out.println("�̸��� : " + this.name);
	}
	// 2���� ������� : ��ӹ��� age�� name
	// 2���� �ż��� : ��ӹ��� output�� print
}



public class InheritanceTest1 {
	public static void main(String[] args) {
		// �ƹ������� ��ü ���� �� ����
		Parent p = new Parent();
		p.age = 50;
		p.output();

		Child c = new Child();
		// ��������� �����ϴ��� �ƹ����� �ڵ嵵 ���� �����
		c.age = 25;
		c.name = "ȫ�浿";
//		c.output();
		c.print();
	}

}
