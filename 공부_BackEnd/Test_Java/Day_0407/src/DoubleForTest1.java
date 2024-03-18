
public class DoubleForTest1 {

	public static void main(String[] args) {
		for (int i=1; i<=5; ++i) {
			System.out.print(i + " : ");
			for (char ch='A'; ch <= 'Z'; ++ch) {
				System.out.print(ch + " "); // 5*26
			}
			System.out.println();
		}
	}

}
