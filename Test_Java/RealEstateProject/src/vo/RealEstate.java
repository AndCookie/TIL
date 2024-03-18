package vo;

public class RealEstate {
	// �������
	private String address;
	private String houseType; // ��ü����
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
	
	// ������
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