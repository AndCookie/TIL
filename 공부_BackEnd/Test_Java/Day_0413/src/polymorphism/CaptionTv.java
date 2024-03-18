package polymorphism;

public class CaptionTv extends Tv { // 부모 : TV // 자식 CaptionTv
	// 멤버변수
	private String text;

	// getter, setter
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	// toString
	@Override
	public String toString() {
		return "CaptionTv [text=" + text + "]";
	}
	
	
}
