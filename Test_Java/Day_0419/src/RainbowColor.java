public enum RainbowColor {
	��("red", "rouge"), ��("orange"), ��("yellow"),
	��("green", "vert"), ��("blue"), ��(), ��("purple");
	
	//////////////////////////////////////////////////////
	RainbowColor() {
		// ������ ���� �⺻ ������
	}
	
	//////////////////////////////////////////////////////
	RainbowColor(String data) {
		this.data = data;
	}
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	//////////////////////////////////////////////////////
	RainbowColor(String string, String string2) {
		// ��, �ʸ� ���� ������
		this.string = string;
		this.string2 = string2;
	}
	private String string, string2;

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	
	

	
}
