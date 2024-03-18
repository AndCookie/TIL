package third;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * connection을 연결하고 끊는 작업만 ConnectionManager라는 클래스로 따로 밖으로 뺀 버전
 */

public class JDBC_Test07 {

	public static void main(String[] args) {

		// 3. SQL명령문, Connection객체, PreparedStatement객체 준비하기
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null; // Statement 객체 대신 PreapredStatement 쓴 것
		String query = null;

		// 4. 
		try {
			query = "SELECT FIRST_NAME, DEPARTMENT_NAME, SALARY " //끝에 띄어쓰기 1개 
		               + "FROM EMPLOYEES JOIN DEPARTMENTS "
		               + "USING (DEPARTMENT_ID) ";  //테이블 반환
		
			// 문장 준비하고
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수

			// 문장 실행하고
			ResultSet rs = pstmt.executeQuery(); // int가 아니라 TABLE, 즉 ResultSet을 반환받고자 함

			while (rs.next()) { // true 또는 false
				Employee emp = new Employee(rs.getString(1), rs.getString(2), rs.getDouble(3)); // 생성자 : Employee 객체 생성하는 역할
				System.out.print(emp);
			}

			// Add catch clause to surrounding try 또는 Add exception to existing catch clause 중에 하나 선택	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// pstmt와 conn 닫기
			try {
				pstmt.close();
				ConnectionManager.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
