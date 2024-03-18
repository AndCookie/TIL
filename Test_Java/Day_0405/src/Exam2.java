import java.util.Scanner;

/*
 * [문제] 삼항연산자를 이용하시오.
 * 한 페이지 글 : 10
 * 전체 글의 개수가 154개 일 때
 * 몇 페이지 일까요? 16페이지
 */
public class Exam2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in); //ctrl + shift + o
		final int countPerPage = 10; // 페이지당 글 개수
		int total = 0; // 총 글의 개수 (입력)
		int page = 0; // 총 페이지 개수
		
		System.out.print("전체 글의 개수 : ");
		total = keyin.nextInt();
		
		page = total / countPerPage;
		page += (total%countPerPage > 0) ? 1 : 0;

		
		System.out.println("해당 게시판은 총 " + page + "페이지 입니다.");
		
		keyin.close();
	}

}
