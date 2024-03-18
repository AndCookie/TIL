package arraytest;

public class StudentTest {

	public static void main(String[] args) {
		// 배열 생성
		int[] iary = new int[10]; // 정수로 구성된 배열 // 0~9로 된 10개의 방 생성
		String[] sary = new String[10]; // 문자열로 구성된 배열
		iary[0] =15;
		sary[0] = "대한민국";
		// iary와 sary는 바로 생성 가능하지만,
		// stdary는 반드시 학생 정보를 생성한 후에 배열을 만들 수 있다
		
		// ==객체 배열==
		int count=0;
		Student[] stdary = new Student[10]; //학생(내가 만든 타입)으로 구성된 배열
		stdary[count] = new Student("1", "홍길동", 24); // 학번(Primary Key): 중복 불가 & 이름과 나이: 중복 가능
		++count; // stdary.length 는 방의 개수를 알려주지만, 방에 있는 데이터의 개수는 알려주지 못함

		stdary[count] = new Student("2", "홍길순", 24);
		count++;
		
		stdary[count] = new Student("2", "전우치", 24);
		count++;
		
	}

}
