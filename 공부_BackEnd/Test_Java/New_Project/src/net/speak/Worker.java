package net.speak;

public class Worker extends Man implements Speakable{
	// 생성자
	public Worker(String name) {
		super(name);
	}
	
	// 메소드
	public String speak() {
		return super.getName() + "일꾼은 자기가 맡은 일을 잘하고 싶어한다";
	}
	
}
