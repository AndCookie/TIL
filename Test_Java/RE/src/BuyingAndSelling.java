
public class BuyingAndSelling extends RealEstate {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BuyingAndSelling() {
		super();
	}

	public BuyingAndSelling(int price) {
		super();
		this.price = price;
	}

	public BuyingAndSelling(String address, String houseType, int size) {
		super(address, houseType, size);
		// TODO Auto-generated constructor stub
	}
	
	
}
