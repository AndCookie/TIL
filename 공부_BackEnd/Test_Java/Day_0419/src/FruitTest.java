
public class FruitTest {

	public static void main(String[] args) {
		// 인터페이스꺼 가져올 때
		System.out.println(Fruit.BANANA);
		System.out.println(Fruit.APPLE);
		String data = Fruit.APPLE;
		System.out.println(data);
		System.out.println(data.getClass());
		// String 타입
		
		// ENUM꺼 가져올 때
		MyFavorite f = MyFavorite.BANANA;
		System.out.println(f);
		System.out.println(f.getClass());
		// String이 아닌 MyFavorite타입임 -> 매칭 타입으로 가져다 쓸 수 있음
		String kor = MyFavorite.BANANA.getKorean();
		System.out.println(kor);
		System.out.println(kor.getClass());
		// String 타입
	}

}
