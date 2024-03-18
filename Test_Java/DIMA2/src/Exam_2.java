import java.util.Scanner;

/*
 * 문자열을 키보드로부터 입력 받아 해당 문자열이 회문(palindrome)인지의 여부를 판단하는 프로그
램을 작성하시오.
문자열의 길이는 3~100자 이내로 입력될 수 있다.
<조건>
문자열의 길이는 특별히 체크하지 않으며, 사용자의 입력에 오류가 없다고 가정한다.
띄어쓰기나 마침표는 입력하지 않으며 배열을 사용하지 않아야 한다.
<실행 예>
입력 : abba
출력 : 'abba'는 회문입니다.
- 예2)
입력 : korea
출력 : 'korea'는 회문이 아닙니다.
- 예3)
입력 : 소주만병만주소
출력 : '소주만병만주소'는 회문입니다.
- 예4)
입력 : 다시합시다
출력 : '다시합시다'는 회문입니다.
 * 
 */
public class Exam_2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String data;
		
		System.out.println("입력 : ");
		data = keyin.next();
		
		for (int i=0; i<data.length()/2; ++i) {
			if (data.charAt(i) != data.charAt(data.length()-i-1)) {
				System.out.println("'"+ data +"'는 회문이 아닙니다.");
				return;
			}
		}
		System.out.println("'"+ data +"'는 회문이 아닙니다.");
		
		
		
		keyin.close();

	}

}