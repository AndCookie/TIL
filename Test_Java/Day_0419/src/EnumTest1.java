// 지금은 EnumTest 안에 같이 생성했지만, 다른 클래스 파일로 만들어도 됨
//enum Season {
//	봄, 여름, 가을, 겨울;	
//}

//Season이 하나의 데이터 타입이 되는 것
//class Friend {
//	
//}


public class EnumTest1 {
	// 특정 클래스 안에 내부 데이터 타입으로도 사용 가능하며 이때 지역변수 역할을 함
	enum Season {
		봄, 여름, 가을, 겨울;	
	}

	public static void main(String[] args) {
		Season s = Season.봄; // STATIC FINAL
//		Season s = "봄"// 불가능 : 여기서의 봄은 String이니까 타입 불일치
		System.out.println(s);
	}

}
