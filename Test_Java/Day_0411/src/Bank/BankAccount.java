package Bank;

// VO (Value Object) : ���� ������ ���� �뵵�� �ƴ϶� �ܼ��� �׽�Ʈ�� ������ ���� �뵵
public class BankAccount {
	// �������
	private String accountNo; // ���¹�ȣ
	private String accountName; // ������
	private int balance; // �ܾ�
//	private double t1;
//	private boolean t2;
	
	// �⺻ ������
	// alt+s : generate constructor using fields(field�� ���� ��������� �ǹ���)
	public BankAccount() {
		super();
	}

	// �����ε�� ������
	public BankAccount(String accountNo, String accountName, int balance) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	
	// setter & getter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() { // �ܾ� ��ȸ
		return balance;
	}
	public void setBalance(int balance) { // ���� ����
		this.balance = balance;
	}
	
	// ���� �����ϴ� �޼ҵ带 �ۼ� : �ܾ� Ȯ�ΰ� ���� �����ϴ� ���� �����ؾ��ϱ� ����
	// �������ڷ� ������ �ݾ��� ���� ���� // ���� ����
	// balance < money ==> 0 ��ȯ
	// balance >= money ==> money ��ȯ, �ܾ��� ����
	public int withdraw(int money){
		if (this.balance<money) return 0;
		else {
			this.balance -= money;
			return money;
		}
	}
	
	// ���� �Ա��ϴ� �޼ҵ带 �ۼ�
	// ���� �Ǵ� 0�� �Է½� ==> 0 ��ȯ
	// ��� �Է½� ==> balance+money ��ȯ (balance�� �츮 ���, money�� �ƴ�)
	public int deposit(int money) {
		if (money<=0) return 0;
		else {
			this.balance += money;
			return this.balance;
		}
	// public int�� �ƴ� public void ���ٸ� return�� ���� �ʿ� ����
	}
	
	// output �޼ҵ�
	public void output() { // static�� �츮 ����� �� �� �����Ƿ� �����ؾ�	
		System.out.println("���¹�ȣ : " + accountNo);
		System.out.println("������ : " + accountName);
		System.out.println("�ܾ� : " + balance);
//		System.out.println("������ �ʱ�ȭ: " + t1);
//		System.out.println("������ �ʱ�ȭ : " + t2);

	}
	
}
