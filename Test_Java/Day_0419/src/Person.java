
public enum Person {
	�տ���("������"){
		public String work() {
			return "������ ����";
		}
	},
	�����("����"){
		public String work() {
			return "�ѹ��� ����";
		}
	},
	���Ȱ�("����"){
		public String work() {
			return "��ȹ�� �븮";
		}
	},
	�������("����"){
		public String work() {
			return "����� ����";
		}
	},
	����ġ("����");

	private String nickName; // �����̸� �ޱ� ���� ����

	Person(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public String work() {
		return "??";
		// ���������� work�� �����Ǿ����� ���� ����ġ�� ��쿡�� ??�� ��ȯ�ȴ�
	}

}
