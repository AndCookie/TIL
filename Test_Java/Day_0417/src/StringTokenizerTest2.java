import java.util.StringTokenizer;

public class StringTokenizerTest2 {

	public static void main(String[] args) {
		String party = "풍선/25000, 케잌/37000, 폭죽/10000"
				+ ", 샴페인/50000, 꽃다발/75000";
		
		// 전역변수
		StringBuffer buf = new StringBuffer();
		int total = 0;
		
		// 분해 (StringTokenizer)
		StringTokenizer stk = new StringTokenizer(party, "/, "); // ctrl+shift+o로 import
//		System.out.println(stk.countTokens()); // 토큰의 개수 = 10
		
		while (stk.hasMoreTokens()) {
			String item = stk.nextToken();
			buf.append(item).append(", ");
			int price = Integer.parseInt(stk.nextToken());
			total += price;
			System.out.println(item + "\t" + price);
		}
		
		System.out.println("======================");
		System.out.println("파티 아이템 : " + buf.toString());
		System.out.println("총 지출금액 : " + String.format("%,d", total) + "원");
		// %,d : 세 자리마다 콤마 넣을 수 있음!!
		
	}

}
