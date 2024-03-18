package vo;

public class BuyingAndSelling extends RealEstate {
	private int price;

	// setter, getter
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	// �⺻ ������
	public BuyingAndSelling() {
		super();
	}
	// price�� �ʱ�ȭ���ִ� �����ε��� ������
	public BuyingAndSelling(int price) {
		super();
		this.price = price;
	}
	// �θ� Ŭ������ ������
	public BuyingAndSelling(String address, String houseType, int size, int price) {
		super(address, houseType, size);
		// �ƹ��� �����ڸ� ���ؼ� ��ӹ��� Ŭ������ �����Ͽ� �ʱ�ȭ
		this.price = price;
		// ���� �ʱ�ȭ
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + ", " + price;
	}
	
	
}
