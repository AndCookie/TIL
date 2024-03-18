public enum RainbowColor {
	빨("red", "rouge"), 주("orange"), 노("yellow"),
	초("green", "vert"), 파("blue"), 남(), 보("purple");
	
	//////////////////////////////////////////////////////
	RainbowColor() {
		// 남색을 위한 기본 생성자
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
		// 빨, 초를 위한 생성자
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
