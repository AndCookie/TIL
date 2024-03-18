import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test01 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// localhost는 url이므로 ip주소인 151.65.61를 대신 넣어도 됨
		// 예시 : jdbc:oracle:thin:@151.65.61:1521:xe
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 패키지명 : oracle.jdbc.driver.
		// 클래스명 : OracleDriver
		String id = "hr"; // 계정 이름
		String pw = "hr"; // 계정 비번

		Connection conn = null; // 연결을 위해 Connection이라는 객체가 필요하다!!
		Statement stat = null; // 명령문 실행을 위한 객체 // 인터페이스이므로 다형성임
		String query = null; //문자열


		try {
			Class.forName(driver);
			// driver 클래스를 메모리에 올리기 // 단, new가 아니라 Class.forName()을 사용
			// 이탤릭체 : forName이 static method라는 의미로 항상 conn보다 위에 있어야 함
			
			conn = DriverManager.getConnection(url, id, pw); // 세 개의 파라미터를 전달하여 Connection객체를 얻어오기
			query = "CREATE TABLE MY_TABLE (" // 테이블은 단 하나만 생성 가능
					+ "	USERNAME VARCHAR2(5)," // 앞에 공백 필수!!
					+ "	AGE NUMBER(3)"
					+ "	)"; // 안쪽의 세미콜론은 삭제하기

			stat = conn.createStatement();
			stat.executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				stat.close();
				conn.close();
				// 위의 try문에 한꺼번에 같이 쓰지 않는 이유 :
				// 만약 stat에서 오류나면 close 종료 못하고 오류 터지기 때문에 finally에 넣어야 함
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("끝!");
	}
}



// 아래의 코드를 축약한 것이 위의 코드

//public class JDBCTest01 {
//
//	public static void main(String[] args) {
//		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String id  = "hr";
//		String pwd = "hr"; 
//		
//		Connection conn = null;
//		Statement stat = null;
//		String query = null;
//		
//		// driver 클래스를 메모리에 올리기 // 단, new가 아니라 Class.forName()을 사용
//		try {
//			Class.forName(driver);
		//catched exception : 문자열인지 확인해야하므로 exception처리를 반드시 하라는 경고 밑줄이 생기므로 surround 어쩌고 선택하기
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패"); // 즉, 드라이버가 안붙었을 때 생성되는 오류 메세지
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			conn = DriverManager.getConnection(url, id, pwd);
//			query = "CREATE TABLE MY_TABLE ( "
//					+ "  USERNAME VARCHAR2(5), "
//					+ "  AGE NUMBER(3) "
//					+ ")";
//			
//			stat = conn.createStatement();
//			stat.executeQuery(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			stat.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("끝!!");
//	}
//
//}
