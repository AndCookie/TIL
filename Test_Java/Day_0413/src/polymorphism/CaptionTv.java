package polymorphism;

public class CaptionTv extends Tv { // �θ� : TV // �ڽ� CaptionTv
	// �������
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
