package bank_v3;
//================== Ŭ���� ���̾�׷� =================
//main ----> service ----> BankAccount
//main�� service�� �����ϰ�, service�� bankaccount�� �����ϴ� ����
//service : ����� ���� ���.
//bankaccount : �����͸� ���� ����.

public class BankAccountTest {
// ��Ŭ�� : run as 1st~~~
	public static void main(String[] args) {
		// BankAccountService service = new BankAccountService();
		// service��� ������ new BankAccountService()�� ������ ���ε�
		// �Ʒ��� �ƹ��� ���� ���ٴ� ���� stack�������� �������� �ʴ´ٴ� �ǹ��̹Ƿ� service�� ����
		new BankAccountService();
	}

}
