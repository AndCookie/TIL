
public class ForTest1 {

	public static void main(String[] args) {
		// for를 이용하여 1~10까지 출력하는 반복문을 작성하시오. for
		for (int i=1; i<=10; ++i) {
			System.out.print(i + " ");
		}
		System.out.println(); // 아무것도 없으면 줄 나누는 것
		
		// 대문자 A ~ Z까지 반복적으로 출력
		for (char j='A'; j<='Z'; ++j) {
			System.out.print(j + " ");
		}
		System.out.println(); // 아무것도 없으면 줄 나누는 것
		
		// 대문자 A ~ 소문자z까지 반복적으로 출력
		for (char j='A'; j<='z'; ++j) {
			System.out.print(j + " ");
		}
		System.out.println(); // 아무것도 없으면 줄 나누는 것

	}

}
