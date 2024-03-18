package Bank;
//================== 클래스 다이어그램 =================
//main ----> service ----> BankAccount
//main이 service를 실행하고, service가 bankaccount를 실행하는 구조
//service : 기능을 갖고 운영함.
//bankaccount : 데이터를 갖고 있음.

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccountService service = new BankAccountService();

	}

}
