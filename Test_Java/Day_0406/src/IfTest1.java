/*
 * if문 버전 1
 * - 실행문이 한 개 뿐일 때는 중괄호 생략 가능
 *
 * 전체선택 (ctrl+a) -> ctrl+i(indent)
 * 
 */
public class IfTest1 {

	public static void main(String[] args) {
		// v1
		int a = 10;
		if (a>5)
			System.out.println("큰 값이다.");
		System.out.println("끝!"); // indent 자동 들여쓰기
		
		
		// v2. 양수인지 음수인지. 0은 제외
		int b = -9;	
		if (b>0) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		// 중괄호 생략해도 되고 한 줄로 써도 됨
		if (b>0) System.out.println("양수");
		else System.out.println("음수");
		
		
		
		// v3. 양수인지 음수인지 0인지
		int c = -9;
		if (c>0) {
			System.out.println("양수");
		} else if (c<0) {
			System.out.println("음수");
		} else {
			System.out.println("0");
		}
		// 중괄호 생략해도 되고 한 줄로 써도 됨
		if (c>0) System.out.println("양수");
		else if (c<0) System.out.println("음수");
		else System.out.println("0");

		
	}

}
