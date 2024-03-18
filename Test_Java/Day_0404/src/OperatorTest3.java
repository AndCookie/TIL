
public class OperatorTest3 {

	public static void main(String[] args) {
		String id = "230014";
		String name = "손오공";
		int prog = 98;
		int math = 87;
		int eng = 100;
		double total = prog *0.4 + math*0.3 + eng*0.3;
		System.out.printf("학번 : %s\n이름 : %s\n프로그래밍 : %d\n수학 : %d\n영어 : %d\n합계 : %.2f점",
				id, name, prog, math, eng, total);

	}

}
