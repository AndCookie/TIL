package polymorphism;

public class FourKTv extends Tv {
	// ��� ����
	private int resolution; // �ػ�
	
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
