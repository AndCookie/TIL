
public class WhileTest1 {

	public static void main(String[] args) {
		int i = 0;
		
		while (i<10) {
			++i;
//			if (i>10) break; // break는  벗어나고자 할 때 쓰는 것
			if (i%2==0) continue; // 진행방향을 바꿔서 다시 조건식으로 간다
			System.out.println(i);
//			++i;
		}
		
//		System.out.println("끝! " + i);
	}

}
