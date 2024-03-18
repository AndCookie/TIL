package Bank;

// VO (Value Object) : 값을 가지기 위한 용도가 아니라 단순히 테스트를 돌리기 위한 용도
public class BankAccount {
	// 멤버변수
	private String accountNo; // 계좌번호
	private String accountName; // 계좌주
	private int balance; // 잔액
//	private double t1;
//	private boolean t2;
	
	// 기본 생성자
	// alt+s : generate constructor using fields(field는 위의 멤버변수를 의미함)
	public BankAccount() {
		super();
	}

	// 오버로드된 생성자
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
	public int getBalance() { // 잔액 조회
		return balance;
	}
	public void setBalance(int balance) { // 돈을 예금
		this.balance = balance;
	}
	
	// 돈을 인출하는 메소드를 작성 : 잔액 확인과 돈을 인출하는 것은 상이해야하기 때문
	// 전달인자로 인출할 금액을 전달 받음 // 돈을 예금
	// balance < money ==> 0 반환
	// balance >= money ==> money 반환, 잔액은 차감
	public int withdraw(int money){
		if (this.balance<money) return 0;
		else {
			this.balance -= money;
			return money;
		}
	}
	
	// 돈을 입금하는 메소드를 작성
	// 음수 또는 0이 입력시 ==> 0 반환
	// 양수 입력시 ==> balance+money 반환 (balance는 우리 멤버, money는 아님)
	public int deposit(int money) {
		if (money<=0) return 0;
		else {
			this.balance += money;
			return this.balance;
		}
	// public int가 아닌 public void 였다면 return문 만들 필요 없음
	}
	
	// output 메소드
	public void output() { // static은 우리 멤버가 될 수 없으므로 삭제해야	
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("계좌주 : " + accountName);
		System.out.println("잔액 : " + balance);
//		System.out.println("더블형 초기화: " + t1);
//		System.out.println("진위형 초기화 : " + t2);

	}
	
}
