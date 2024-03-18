import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Test02 {

	public static void main(String[] args) {
		
		// 1. 디펜던시 두 개 추가하기
		// 패키지에서 우클릭 > Build Path > Configure Build Path > Libraries > Add External Jars > mybatis랑 ojdbc 추가
		
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
			query = "INSERT INTO MY_TABLE"
					+ " (USERNAME, AGE)"
					+ " VALUES"
//					+ " ('홍', 25)"
					+ " ('손', 30)";			
			// 커넥션 열고
			conn = DriverManager.getConnection(url, userid, userpw);
			// 문장 준비하고
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}