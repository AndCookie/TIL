// enum ��ü�� public�� ���� �� ������
// enum�� �����ڴ� public�� ���� �� ����

//public enum Season {
//	��, ����, ����, �ܿ�;
//	
////	public Season() // private�ϹǷ� public���� �����ڸ� ���� �� ����!!!!
//	Season() {
//		System.out.println("���� " + this);
//		// this : �ڱ� �ڽ� : ������ ������ : ��,����,����,�ܿ�
//	}
//
//}


//public enum Season {
//	��("Spring"), ����("Summer"), ����("Fall"), �ܿ�("Winter");
//	// ���� ������ �ϳ��ϳ��� �����ڸ� ȣ���ϴ� ������ ��
//	
//	public String data;
//
//	Season(String data) {
//		this.data = data;
//	}
//
//}


// private���� �ϸ� getData�޼ҵ带 ���ؼ� ��ȸ������ ���� ����
public enum Season {
	��("Spring"), ����("Summer"), ����("Fall"), �ܿ�("Winter");
	// ���� ������ �ϳ��ϳ��� �����ڸ� ȣ���ϴ� ������ ��
	
	private String data;

	Season(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}