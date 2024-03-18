package vo;

public class Charter extends RealEstate {
	private int depositMoney;
	
	// setter, getter
	public int getDepositMoney() {
		return depositMoney;
	}
	public void setDepositMoney(int depositMoney) {
		this.depositMoney = depositMoney;
	}
	
	// »ý¼ºÀÚ
	public Charter() {
		super();
	}
	public Charter(int depositMoney) {
		super();
		this.depositMoney = depositMoney;
	}
	public Charter(String address, String houseType, int size, int depositMoney) {
		super(address, houseType, size);
		this.depositMoney = depositMoney;
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + ", " + depositMoney;
	}
	
	
	
	
}
