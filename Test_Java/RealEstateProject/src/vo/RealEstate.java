package vo;

public class RealEstate {
	// 멤버변수
	private String address;
	private String houseType; // 전체월세
	private int size;
	
	// setter, getter
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// 생성자
	public RealEstate() {
		super();
	}
	public RealEstate(String address, String houseType, int size) {
		super();
		this.address = address;
		this.houseType = houseType;
		this.size = size;
	}
	
	// toString
	@Override
	public String toString() {
		return "RealEstate [address=" + address + ", houseType=" + houseType + ", size=" + size + "]";
	}
	
	
}
