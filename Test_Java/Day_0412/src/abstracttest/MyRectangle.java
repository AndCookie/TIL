package abstracttest;

//public class MyRectangle : public�� �ٿ��� �ٸ� ��Ű�������� �� �� ����
//class MyRectangle : ���� ��Ű�������� ��� �����ϸ� �ٸ� ��Ű�������� ��� �Ұ� = ����Ʈ Ŭ���� = ��Ű�� Ŭ����
public class MyRectangle extends MyPoint {
	// �������
	private double width;
	private double height;
	
	// �⺻������
	public MyRectangle() {
		super(); // �θ��� �����ڸ� ȣ�� // �������� ���� ��ܿ� �;��� // ������ ����
	}
	// �����ε�� ������
	public MyRectangle(double width, double height) { // ������
		super(); // �θ��� �����ڸ� ȣ�� // �������� ���� ��ܿ� �;��� // ������ ����
		this.width = width;
		this.height = height;
	}
	
	// getter, setter
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;	
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	//�������̵�
	// abstract Ŭ������ ��ӹ��� �ڽĵ��� ������ abstract �޼ҵ带 override �ؾ���
	@Override
	public double area() {
		return height * width;
	}	
	
	// �������̵�
	@Override
	public String toString() {
		return super.toString() + ", " + "width=" + width
				+ ", height=" + height + ", area=" + area();
		// super.toString() : �θ�Ŭ������ toString�� ���ڿ��� ��ȯ
	}

	
}