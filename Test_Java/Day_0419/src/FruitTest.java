
public class FruitTest {

	public static void main(String[] args) {
		// �������̽��� ������ ��
		System.out.println(Fruit.BANANA);
		System.out.println(Fruit.APPLE);
		String data = Fruit.APPLE;
		System.out.println(data);
		System.out.println(data.getClass());
		// String Ÿ��
		
		// ENUM�� ������ ��
		MyFavorite f = MyFavorite.BANANA;
		System.out.println(f);
		System.out.println(f.getClass());
		// String�� �ƴ� MyFavoriteŸ���� -> ��Ī Ÿ������ ������ �� �� ����
		String kor = MyFavorite.BANANA.getKorean();
		System.out.println(kor);
		System.out.println(kor.getClass());
		// String Ÿ��
	}

}
