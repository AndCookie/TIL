package polymorphism;

public class TvTest {

	public static void main(String[] args) {
//		// ���� ���
//		Tv t = new Tv();
//		t.channelUp();
//		System.out.println(t);
		
//		// ������
//		// ��ĳ����
//		Tv t1 = new CaptionTv();
//		System.out.println(t1.getClass());
//		// t1�� �θ� �͸� ��밡���ϰ� �ڽ� ���� ���Ұ���...
//		
//		// �ٿ�ĳ����
//		((CaptionTv)(t1)).getText();
//		// ���� �θ�, �ڽ��� �� ��� ��� ����
		// ��ȣ�� �����ٸ� .�� �������� �켱������ �����Ƿ� ���� �߻���!
		// (CaptionTv)t1.getText()�� ����~
		
		CaptionTv c = new CaptionTv();
		FourKTv f = new FourKTv();
		
		output(c);
		output(f);
	}

	
	
	// CaptionTv�� FourKTv ��� Tv�� �ڽ��̴ϱ�!!!
	// ������ �� �ʿ� ����, Tv t�� �� ���� ������
//	public static void output(CaptionTv c) {
//		///
//	}
//	// �����ε�
//	public static void output(FourKTv f) {
//		///
//	}
	
	// TvŸ�� t�� ��� �ڽ��� ������ �� �ִ�. (output�� c��, f�Ŀ� ���� �޶���!!!!)
	public static void output(Tv t) { // ���� ���۷��� ����t�� ���� ��ü(caption�� fourk)�� ������
//		System.out.println(t instanceof Tv); // TRUE : t�� Tv��???
//		System.out.println(t instanceof CaptionTv); // TRUE : t�� �ڽ� �������� Caption�� ����Ű�� �ֳ�?
//		System.out.println(t instanceof FourKTv); // FALSE : t�� �ڽ� �������� FourK�� ����Ű�� �ֳ�?
//		// instanceof : ���׿����ڷ� true/false ��ȯ (�ڿ� Ŭ������ �Է� ����)
		
		if (t instanceof CaptionTv) {
			((CaptionTv)t).channelUp(); // ������ ���������� �ٿ�ĳ�����ؾ��Ѵ�
		} else {
			((FourKTv)t).getResolution();
		}
	}
	// ��, �ϳ��� �ڽ� Ŭ������ ��� �� �� �ִ�~~~~~
	
}
