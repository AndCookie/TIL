package third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton pattern : 객체를 전체 프로젝트 내에서 하나 밖에 못만드는 것
// 1.  생성자는 private : 외부에서 new로 생성 불가능하며 연결을 잇고 끊는 작업만 수행
// 2.  멤버들은 static final
// 객체를 전체 프로젝트 내에서 단 한 번만 생성할 수 있도록 함

public class ConnectionManager {
	
	// 1) 멤버들을 static final로 만들기 (싱글턴 패턴으로 만들기 위한 작업)
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String userid = "hr";
	private static final String userpw = "hr";
	
	// 2) 외부에서 new 불가
	private ConnectionManager() {};
	// private 생성자로 만들어서 다른 곳에서 new로 못쓰게 막아버린 것
	
	// 3) static블럭을 이용하여 static 멤버를 메모리에 로딩함
	// static블럭이란? : static {}의 구조로 생겼으며 생성자와 유사한 역할을 한다
	// 대신 생성자는 new 할 때마다 메모리에 올리지만, static 블럭은 단 한 번만 메모리에 올리는 장치
	static {
		try {
			// 메모리에 올리고
			Class.forName(driver); // driver 클래스를 메모리에 올리기 // 단, new가 아니라 Class.forName()을 사용
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 4) public 메소드를 이용하여 Connection을 외부에서 사용할 수 있도록 해줌	
	// 이때까지 main에서 conncect했는데, 이제는 ConnectionManager가 이 역할을 대신함
	public static Connection getConnection() {
		Connection conn = null;
		// 커넥션 열고
		try {
			conn = DriverManager.getConnection(url, userid, userpw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; 
	}
	
	// 5) Connection 객체의 연결 설정을 끝어주는 작업
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

