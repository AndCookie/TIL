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
	
	
	// 기본 생성자
	public BuyingAndSelling() {
		super();
	}
	// price를 초기화해주는 오버로딩된 생성자
	public BuyingAndSelling(int price) {
		super();
		this.price = price;
	}
	// 부모 클래스의 생성자
	public BuyingAndSelling(String address, String houseType, int size, int price) {
		super(address, houseType, size);
		// 아버지 생성자를 통해서 상속받은 클래스를 생성하여 초기화
		this.price = price;
		// 내꺼 초기화
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + ", " + price;
	}
	
	
}
