class Person {
	// �������
	private String name;
	private int age;
	
	// ������
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
	
	// toString : ���ڿ��� ��ȯ���ִ� ����
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	// equals : �������� ������ equals
	@Override
	public boolean equals(Object obj) {
//		this
		// this�� p1 : ȣ���� �� : Person Ÿ�� // obj�� p2 : Object Ÿ��
		// �������ڸ� Object�� �޴ٺ��� ������ Ÿ���� �޶� �񱳰� �Ұ���
		// ���� p2�� ObjectŸ�Կ��� Person Ÿ������  �ٿ�ĳ���� �ؾ���
		// �׷��� ���� p2�� �ƴ϶� obj�� �������ڷ� �ִ´ٸ�?
		// PersonŸ������ �ٿ�ĳ���� ��ȯ �Ұ���,,
		// ���� instanceof �����ڷ� ��� ����Ű�� �ִ��� Ȯ���ؾ��Ѵ�
		
		Person temp = null; // if�� �ۿ��� ����Ϸ��� �̸� �����ص־� �ϴϱ� :)
		if (obj instanceof Person) {
			temp = (Person)(obj); // �ٿ�ĳ���� // this ==> p1, temp ==> p2
			// �ٿ�ĳ������ ���� �Ŀ� �� ��Ұ� ������ ���ؾ���
			if (this.name.equals(temp.name) && // ���ڿ� �񱳴� equals
					this.age == temp.age) // int �񱳴� �񱳿����� ==
			return true;
			else
				return false;
		} else {
			return false;
		}
	}


	// JVM�� ������ִ� ��
//	@Override
//	public int hashCode() {
//		�ؽ��ڵ� �������̵��� p1�� p2�� ���� �ּҸ� �����Ͽ� �ٶ󺸰� ����Ƿ� �ּ� ó���Ͽ� ���� �ʰڴ�
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) // this ==> p1 // obj == > p2
//			return true;
//		if (obj == null) // �������ڰ� null�� ���
//			return false;
//		if (getClass() != obj.getClass()) // Ÿ���� �ٸ� ���
//			return false;
//		Person other = (Person) obj; // �ٿ�ĳ����
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
		Person p1 = new Person("ȫ�浿", 25);
		Person p2 = new Person("ȫ�浿", 25);
		
		
		// Person Ÿ���� ���� �� equals��� �޼ҵ带 ���� ���� ������
		// Object ���� Ŭ�����κ��� ��ӹ��� �޼ҵ�� ���� �߻����� �ʴ� ��
		System.out.println(p1 == p2); // FALSE : p1�� p2�� �ּҰ��� �ٸ�
		System.out.println(p1.equals(p2));
		// FALSE : object�κ��� ��ӹ��� equals��  Person�� ���� �ʴ� ��.. ���� �� �Ұ�
		// ���������� Object obj�� �θ�Ŭ����, �ڽ�Ŭ���� ��� ���� �� �ֱ� ������ �� �Ұ�
		// ���� equals �޼ҵ带 Override ����� ��
		
		System.out.println(p1.toString());
		// ���� toString�� �������̵� ���� ������ �ؽ��ּҰ� ��µ�
		// toString�� �������̵� �� �Ŀ��� ���� ���� ��µ�
		
	}

}
