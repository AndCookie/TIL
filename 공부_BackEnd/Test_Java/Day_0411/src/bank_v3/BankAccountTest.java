package bank_v3;
//================== 클래스 다이어그램 =================
//main ----> service ----> BankAccount
//main이 service를 실행하고, service가 bankaccount를 실행하는 구조
//service : 기능을 갖고 운영함.
//bankaccount : 데이터를 갖고 있음.

public class BankAccountTest {
// 우클릭 : run as 1st~~~
	public static void main(String[] args) {
		// BankAccountService service = new BankAccountService();
		// service라는 변수에 new BankAccountService()을 대입한 것인데
		// 아래에 아무런 식이 없다는 것은 stack영역에서 참조하지 않는다는 의미이므로 service를 생략
		new BankAccountService();
	}

}
