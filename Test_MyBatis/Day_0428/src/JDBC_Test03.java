import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Test03 {

	public static void main(String[] args) {
		
		// 1. 디펜던시 두 개 추가하기
		// 패키지에서 우클릭 > Build Path > Configure Build Path > Libraries > Add External Jars > mybatis랑 ojdbc 추가
		
		Scanner keyin = new Scanner(System.in);
		
		// 2. url, driver, userid, userpwd을 문자열로 세팅하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String userid = "hr";
		String userpw = "hr";
		
		// 3. SQL명령문, Connection객체, PreparedStatement객체 준비하기
		String query = null;
		Connection conn = null; // ctrl+shift+o
		PreparedStatement pstmt = null; // Statement 객체 대신 PreapredStatement 쓴 것
		
		// 4. 
		try {
			// 메모리에 올리고
			Class.forName(driver); // driver 클래스를 메모리에 올리기 // 단, new가 아니라 Class.forName()을 사용
			
			System.out.println("이름을 입력하시오 : ");
			String name = keyin.next();
			
			System.out.println("나이를 입력하시오 : ");
			int age = keyin.nextInt();
			
			query = "INSERT INTO MY_TABLE"
					+ " (USERNAME, AGE)"
					+ " VALUES"
//					+ " ('홍', 25)"
//					+ " ('손', 30)"
//					+ " ('"+ name + "', "+ age +")" // 비추 (오라클에서 사용하는 작은따옴표도 꼭 넣어줘야 하므로 코드가 지저분함)
					+ " ( ? , ? )"; // placeholder인 물음표를 끼워두기 // 장점 : 오라클에서 사용하는 작은따옴표도 뺄 수 있음
			
			
			// 커넥션 열고
			conn = DriverManager.getConnection(url, userid, userpw);
			
			// 문장 준비하고
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			pstmt.setString(1, name); // 첫 번째 place holder에는 name이 들어갑니다~
			pstmt.setInt(2, age); // 두 번째 place holder에는 age가 들어갑니다~
			
			// 문장 실행하고
			int result = pstmt.executeUpdate(); // int를 반환해주는 함수
			System.out.println("결과: " + result); // n개의 행이 정상적으로 저장되었다는 의미
		
		// Add catch clause to surrounding try 또는 Add exception to existing catch clause 중에 하나 선택	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// pstmt와 conn 닫기
			try {
				pstmt.close();
				conn.close();
				keyin.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
