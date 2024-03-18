package abstracttest;
// abstract�� ���� ���� ��ü ���� ���� ����!!!!!!!!!!!!!
// �ȿ� ��ü ������ ���� public abstract double area(); ������ ��ü ���� �ȵǴ� ��

// ���� ��ü �������� �����״ϱ� �ڽĵ�� �˾Ƽ� �ض�~
// abstract Ŭ������ ��ӹ��� �ڽĵ��� ������ abstract�޼ҵ带 override �ؾ���
public abstract class MyPoint {
	// �������
	private int x, y;
	
	// �⺻������ // �޸𸮿� �ø��� 0���� �ʱ�ȭ�ϴ� ����
	public MyPoint() {
		super();
	}
	// �����ε�� ������ // �޸𸮿� �ø��� ���޹��� �� double radius���� �ʱ�ȭ�ϴ� ����
	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	// getter, setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	////////////////////////////////////////////////
	public abstract double area();
	// abstract Ŭ������ ��ӹ��� �ڽĵ��� ������ abstract�޼ҵ带 override �ؾ���
	///////////////////////////////////////////////
	
	// �������̵�
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

}
