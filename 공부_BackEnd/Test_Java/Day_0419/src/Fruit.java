
public interface Fruit {
	String BANANA = "�ٳ���"; // PUBLIC STATIC FINAL
	String APPLE = "���";
	
}


// ���� ���� ���� public�� �� ���� �� ���� ������
// ���� enum�� ���鶧�� public ���� ����ڽ��ϴ�~
//enum MyFavorite {
//	BANANA, APPLE
//}

// ���� �Ʒ�
// ��, �������̽������� ��ü�� �ִ� �޼��带 ���� �� ����
// �ݸ�, ENUM������ CLASS�� �Ȱ��� �޼��嵵 ���� �� �ְ�, �����, ����� ���� �� �ִ�.
// ���, ����� ��ġ��Ű�� �뵵�θ� �� �� �ִ�.
// ��, �������̽�ó�� ����� �����ϱ� ���� �������� ���ǳ�, �޼��带 ���� �� �ִٴ� ������ ���̰� �ִ�.


enum MyFavorite {
	BANANA("�ٳ���"), APPLE; // ���� �����ε�� ������, �⺻ �����ڰ� �ʿ���
	
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