
public class RainbowColorTest2 {

	public static void main(String[] args) {
		// values() : 배열로 반환
		RainbowColor[] color = RainbowColor.values();
		for (RainbowColor c : color) {
			System.out.println(c);
		}
		
		// valueOf(문자열) : 문자열과 매칭되는 enum 데이터 반환 : String으로 반환
		RainbowColor c = RainbowColor.valueOf("주");
		System.out.println(c);
		
		// name() : 해당 enum의 데이터를 문자열로 반환 => toStringIO 동일
		String c1 = c.name();
		String c2 = c.toString();
		System.out.println(c1 + ", " + c2 + ", " + c1.equals(c2));
	
		// ordinal() : 해당 enum의 index를 정수로 반환
		RainbowColor y = RainbowColor.노;
		int o = y.ordinal();
		System.out.println(o);
	}

}
