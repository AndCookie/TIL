package Bank;

public class BankAccountTest_v1 {
	// ���α׷��� �����ϱ� ���ؼ��� main�� �ݵ�� �־�� �ϹǷ�
	// �׽�Ʈ�� ���鶧�� ������ main�� �־�� ��
	public static void main(String[] args) {
		// �޼ҵ带 ���ؼ� ��ȸ������ ����
		// Ŭ������ �����ؼ� ����Ѵ� = �޸𸮿� �÷��� �����Ѵ�
		int money = 5000;
		
		
		// �⺻ ������
		BankAccount ba = new BankAccount(); // ������ �żҵ� (Constructor)
		// ���⼭ ba�� stack ������ ��������� ��������
		// �̶� heap ������ ��������� ���� '��ü'
		ba.output();
		System.out.println("================");
		
		
		// �����ε�� ������
		BankAccount bc = new BankAccount("4567", "�Ӳ���", 50000); // ������ �żҵ� (Constructor)
		// ���⼭ ba�� stack ������ ��������� ��������
		// �̶� heap ������ ��������� ���� '��ü'
		bc.output();
		System.out.println("================");
		
		
		ba.setAccountNo("1234");
		ba.setAccountName("����ġ");
		ba.setBalance(10000);
		
		// ���� ���� ������ �ص��� �ʰ� �ٷ� ba.output(); ����� �⺻������ ���õ� 0�� ��µ�
		System.out.println(money + "�� �Ա�");
		ba.deposit(money);
		int result = ba.getBalance(); // �Ա����� �ʰ� �ܾ�Ȯ�� ������ �޼ҵ�
		// Ŀ�� : �ʷϻ� ���׶��=public / Bank=��Ű���� / BankAccount=Ŭ���׸�
		System.out.println("�ܾ�Ȯ�� : " + result);
		ba.output();
		
		money = 20000;
		System.out.println();
		System.out.println(money + "�� ���");
		result = ba.withdraw(money);
		System.out.println("��� : " + result);
		System.out.println("�ܾ�Ȯ�� : " + ba.getBalance());
		ba.output();		
		
	}

}
