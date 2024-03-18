package vo;

public class MonthlyRent extends RealEstate {
	private int monthlyRent;
	
	// setter, getter
	public int getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	// »ý¼ºÀÚ
	public MonthlyRent() {
		super();
	}
	public MonthlyRent(int monthlyRent) {
		super();
		this.monthlyRent = monthlyRent;
	}
	public MonthlyRent(String address, String houseType, int size, int monthlyRent) {
		super(address, houseType, size);
		this.monthlyRent = monthlyRent;
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + ", " + monthlyRent;
	}
	
}
