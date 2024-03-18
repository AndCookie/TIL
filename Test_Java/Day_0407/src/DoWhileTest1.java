
public class DoWhileTest1 {

	public static void main(String[] args) {
		int i = 0;
		
		do {
			System.out.println(i);
		// ++i는 우선순위 1위 // 만약 연산자 우선순위가 같다면 결합방향 순서대로 연산
//		} while (++i<10); // 0 1 2 .. 9
		} while (i++<10); // 0 1 2 .. 10
		// i=9일 때, 9 < 10 후에 ++하여 10으로 만듦
	}

}
