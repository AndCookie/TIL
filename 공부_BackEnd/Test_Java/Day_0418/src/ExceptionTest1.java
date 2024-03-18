
public class ExceptionTest1 {

	public static void main(String[] args) {
		try {
			int a=10, b=0;
//			int a=10, b=5;
			int result = a/b;
			System.out.println("익셉션이 없으면 실행할 코드: " + result); // 출력 x
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
		} finally {
			System.out.println("무조건 실행! => 주로 뒷마무리 코드들 ");   // 출력 o
		}
		
		System.out.println("끝!!!"); // ====== try-catch와 무관 ====== 출력 o
	}
}
