
public interface Fruit {
	String BANANA = "바나나"; // PUBLIC STATIC FINAL
	String APPLE = "사과";
	
}


// 같은 파일 내에 public이 두 개일 수 없기 때문에
// 지금 enum을 만들때는 public 없이 만들겠습니다~
//enum MyFavorite {
//	BANANA, APPLE
//}

// 위와 아래
// 단, 인터페이스에서는 본체가 있는 메서드를 가질 수 없다
// 반면, ENUM에서는 CLASS와 똑같이 메서드도 가질 수 있고, 멤버도, 상수도 있을 수 있다.
// 대신, 멤버는 일치시키는 용도로만 쓸 수 있다.
// 즉, 인터페이스처럼 상수를 저장하기 위한 목적으로 사용되나, 메서드를 가질 수 있다는 점에서 차이가 있다.


enum MyFavorite {
	BANANA("바나나"), APPLE; // 각각 오버로드된 생성자, 기본 생성자가 필요함
	
	private String korean;
	MyFavorite(String korean) {
		this.korean = korean;
	}
	public String getKorean() {
		return this.korean;
	}


	MyFavorite() {	
	}
}