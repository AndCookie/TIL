// enum 자체는 public을 가질 수 있지만
// enum의 생성자는 public을 가질 수 없다

//public enum Season {
//	봄, 여름, 가을, 겨울;
//	
////	public Season() // private하므로 public으로 생성자를 가질 수 없다!!!!
//	Season() {
//		System.out.println("계절 " + this);
//		// this : 자기 자신 : 각각의 아이템 : 봄,여름,가을,겨울
//	}
//
//}


//public enum Season {
//	봄("Spring"), 여름("Summer"), 가을("Fall"), 겨울("Winter");
//	// 위의 아이템 하나하나가 생성자를 호출하는 역할을 함
//	
//	public String data;
//
//	Season(String data) {
//		this.data = data;
//	}
//
//}


// private으로 하면 getData메소드를 통해서 우회적으로 접근 가능
public enum Season {
	봄("Spring"), 여름("Summer"), 가을("Fall"), 겨울("Winter");
	// 위의 아이템 하나하나가 생성자를 호출하는 역할을 함
	
	private String data;

	Season(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}