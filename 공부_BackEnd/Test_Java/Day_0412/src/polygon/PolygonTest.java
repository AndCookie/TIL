package polygon;


public class PolygonTest {

	public static void main(String[] args) {
		MyCircle c = new MyCircle(5);
		c.setX(1);
		c.setY(1);
		System.out.println(c); // �ؽ��ּ� ��� : ��ŷ ������ �����Ƿ� ��¥ �ּҴ� �˰������� ������ ��
//		// �ؽ��ּ� ��� ������ -> �޸𸮿� �ö������ Ȯ�� ����
//		System.out.println(p.toString()); // ��ü�� ���� �ڵ����� toString�� �ٿ��ֹǷ� �ּ� ������� ����
//		// �θ� Ŭ�������� toString�� override�ϸ� �ּҰ��� �ƴ� ������ ��� ����
	
		MyRectangle r = new MyRectangle(2,5);
		r.setX(4);
		r.setY(10);
		System.out.println(r);
	}

}
