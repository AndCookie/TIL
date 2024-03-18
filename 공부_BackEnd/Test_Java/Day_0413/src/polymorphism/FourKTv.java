package polymorphism;

public class FourKTv extends Tv {
	// 멤버 변수
	private int resolution; // 해상도
	
	// setter, getter
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	// toString
	@Override
	public String toString() {
		return "FourKTv [resolution=" + resolution + "]";
	}
	
	
}
