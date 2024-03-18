/*
 * even 메서드로 짝수 난수를 발생시켜
 * 홀수 발생시 exception으로 처리하기
 * (참고사항 : 실제로 홀수 난수는 오류가 아니지만, 우리가 임의로 오류로 처리하는 것)
 * 
 */
public class ExceptionTest4 {

	public static void main(String[] args) {
		int[] myAry = new int[10]; // 짝수 난수 10개로 구성된 배열 
		
		for (int i=0; i<myAry.length; ++i) {
			try {
				int data = even();
				myAry[i] = data;
			} catch(Exception e) {
				--i;
				continue; // 증감식 ++i으로 이동
				// 만약 위의 두 개 식이 없다면, 배열 내의 홀수 난수 자리가 0으로 채워질 것
			}
			System.out.println(myAry[i]);
		} // end for
	}
	
	// even() = even 메서드 = 짝수 난수 발생 메서드
	public static int even() throws Exception {
		int value = (int)(Math.random()*100);
		// Math.random() : 0.0 이상 1.0미만의 실수 난수 발생
		
		if (value%2!=0) {
			throw new Exception("홀수면 안됨!");
			// new : 객체 생성
			// throw : 메소드를 호출했던 쪽으로 exception을 던지기 (return과 유사)
		}
		return value;
	}

}
