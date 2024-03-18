import java.util.StringTokenizer;

public class StringTokenizerTest1 {

	public static void main(String[] args) {
		String str = "케잌, 꽃다발, 향수";
		// split 불가 : 하나의 문자인 character을 인자로 넣어야하므로
		// StringTokenizer 가능
		
		
		// 기본 구분자 : 공백
		StringTokenizer st1 = new StringTokenizer(str); // ctrl+shift+o로 import
		System.out.println(st1.countTokens()); // 토큰의 개수 = 3
		
		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		
		// 구분자 지정
		StringTokenizer st2 = new StringTokenizer(str, ", "); // ctrl+shift+o로 import
		System.out.println(st2.countTokens()); // 토큰의 개수 = 3
		
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

		
	}

}
