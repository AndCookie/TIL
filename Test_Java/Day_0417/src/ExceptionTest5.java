/*
 * 0~100까지의 난수를 발생시킨다.
 * => 정수 배열 10개짜리 준비!
 * 발생된 난수가 3의 배수이거나 8의 배수인 경우에 배열에 저장하고
 * 그렇지 않은 경우 익셉션 처리하여 모든 배열에 데이터를 넣으시오.
 * 만약 문자가 입력되어도 예외 발생으로 인한 프로그램 종료가 되지 않아야 함.
 */

public class ExceptionTest5 {

	public static void main(String[] args) {
		int[] ary = new int[10]; // 3 또는 8의 배수인 난수 10개로 구성된 배열 
		
		for (int i=0; i<ary.length; ++i) {
			try {
				ary[i] = temp();
			} catch(Exception e) {
				--i;
				continue; // 증감식 ++i으로 이동
				// 만약 위의 두 개 식이 없다면, 배열 내에서 3 또는 8의 배수가 아닌 난수의 자리가 0으로 채워질 것
			}
			System.out.println(ary[i]);
		} // end for
	}
	
	public static int temp() throws Exception {
		int a = (int)(Math.random()*100);
		// Math.random() : 0.0 이상 1.0미만의 실수 난수 발생
		
		if ((a%3!=0)&&(a%8!=0)) { // if(!(a%3==0 || a%8==0))
			throw new Exception("3의 배수 또는 8의 배수여야 합니다!");
			// new : 객체 생성
			// throw : 메소드를 호출했던 쪽으로 exception을 던지기 (return과 유사)
			// 메소드 시그니처 부분에 throws Exception을 적어주기
		}
		return a;
	}
	
}
