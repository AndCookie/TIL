package net.speak;

public class Reader extends Man implements Speakable{
	// ������
	public Reader(String name) {
		super(name);
	}
	
	// �޼ҵ�
	public String speak() {
		return super.getName() + "���ڴ� �ڹٸ� ���ϰ� �ʹ�";
	}
	
}	
	

