package net.speak;

public class Worker extends Man implements Speakable{
	// ������
	public Worker(String name) {
		super(name);
	}
	
	// �޼ҵ�
	public String speak() {
		return super.getName() + "�ϲ��� �ڱⰡ ���� ���� ���ϰ� �;��Ѵ�";
	}
	
}
