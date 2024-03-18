package net.speak;

public class Reader extends Man implements Speakable{
	// 생성자
	public Reader(String name) {
		super(name);
	}
	
	// 메소드
	public String speak() {
		return super.getName() + "독자는 자바를 잘하고 싶다";
	}
	
}	
	

