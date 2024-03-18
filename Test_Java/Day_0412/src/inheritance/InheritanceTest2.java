package inheritance;


//��� Ŭ������ �����ڰ� �־���մϴ�. 
class Parent2 {
//	int age; // default ���� ������ = ���������ڰ� ������ "package ���� ������"��� �Ѵ�.
	private int age;
	
	// �ڽ��� ���� �θ��� �����ڸ� �������� �ʰ� ���� ������ִ� ���� ����..
//	public Parent2() {} // JVM�� �ڵ����� �⺻ �����ڸ� ������ֹǷ� ���� �����ϳ� �ڽ��� ���� ������ִ� �� ����
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
		System.out.println("���̴� : " + age); // this.age
	}
	
	// alt+s : override/implement Ŭ��
	@Override
	public String toString() {
		return "age = " + this.age;
	}
	
	
}



class Child2 extends Parent2 {
	// private int age�� ��ӹ��� �������� getAge��� ��θ� ���ؼ� age�� ��ȸ ���� ����
	private String name;
	
//	public Child2(int age, String name) { // ������
//		super(age); // �θ��� �����ڸ� ȣ�� // �������� ���� ��ܿ� �;��� // ������ ����
//		this.name = name;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// Override �������̵� : �θ�κ��� ��ӹ��� �޼ҵ��δ� ���� �ñ״�ó���� ���� �� ������ ���
	// ��ӹ��� �޼ҵ��� ����� Ȯ��� ����ϴ� ��� // �ƹ��� �޼ҵ�� ��������..
	@Override // JVM �ڹ� ����ӽſ� �������̵� �Ǿ����� �˷��ִ� ��
	public void output() {
		super.output(); // �ƹ��� �� ȣ��
		System.out.println("�̸��� : " + this.name);
	}
	// 2���� ������� : ��ӹ����ʰ� ��ȸ�ؼ� ������ age�� name
	// 2���� �ż��� : ��ӹ������� �ڱ��ڽ��� output�� print
}



public class InheritanceTest2 {
	public static void main(String[] args) {
		// �ƹ������� ��ü ���� �� ����
		Parent2 p = new Parent2(); // p�� ��ġ���� ���� �ִ� ���� ex) stack(100���� p�ڽ�) & heap(~������ 100�ڽ�)
//		p.age = 50; // private�� ���� ������ ��� �Ұ��ϸ� setter, getter�� �ʼ�
		p.setAge(50);
//		p.output();
		
		System.out.println(p); // �ؽ��ּ� ��� : ��ŷ ������ �����Ƿ� ��¥ �ּҴ� �˰������� ������ ��
		// �ؽ��ּ� ��� ������ -> �޸𸮿� �ö������ Ȯ�� ����
//		Child2 temp; // ���� �޸𸮿� �ȿø� ���� ����
//		System.out.println(temp); // �ؽ��ּ� ��� �Ұ����ϹǷ� �޸𸮿� �ȿö������ Ȯ�� ����
		System.out.println(p.toString()); // ��ü�� ���� �ڵ����� toString�� �ٿ��ֹǷ� �ּ� ������� ����
		// �θ� Ŭ�������� toString�� override�ϸ� �ּҰ��� �ƴ� ������ ��� ����

		Child2 c = new Child2();
		// ��������� �����ϴ��� �ƹ����� �ڵ嵵 ���� �����
		c.setAge(25);
		c.setName("ȫ�浿");
//		c.output();

	}

}
