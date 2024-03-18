
public class DoubleForTest2 {

	public static void main(String[] args) {
		for (int i=1; i<=5; ++i) {
			for (int j=1; j<=5; ++j) {
				System.out.print("*"); // 5*26
			}
			System.out.println();
		}
		System.out.println();

		// ===================
		for (int i=1; i<=5; ++i) {
			for (int j=1; j<=i; ++j) {
				System.out.print("*"); 
			}
			System.out.println();
		}
		System.out.println();

		// ===================
		for (int i=1; i<=5; ++i) {
			for (int j=5; j>=i; --j) {
				System.out.print("*"); 
			}
			System.out.println();
		}
		System.out.println();

		// =================== ¾ËÆÄºª
		for (char i='A'; i<='Z'; ++i) {
			for (char j='A'; j<=i; ++j) {
				System.out.print(j); 
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
