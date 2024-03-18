package net.kdigital.fitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.kdigital.fitness.vo.Fitness;

public class FitnessDAOImpl implements FitnessDAO {
	// SQL명령문, Connection객체, PreparedStatement객체 준비하기
	@Override
	public boolean insert(Fitness fitness) {
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO fitness "
				+ "(seqno, userid, username, height, weight) "
				+ "VALUES "
				+ "(fitness_seq.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 문장 준비하기
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			pstmt.setString(1, fitness.getId());
			pstmt.setString(2, fitness.getName());
			pstmt.setDouble(3, fitness.getHeight());
			pstmt.setDouble(4, fitness.getWeight());
			
			// 문장 실행하기
			result = pstmt.executeUpdate(); // insert, update, delete에서 사용
			// executeQuery는 table로 반환하지만 executeUpdate는 int로 반환함 
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

		if (result==1) return true;
		return false;
	}

	@Override
	public Fitness selectOne(String id) {
		
		Connection conn = ConnectionManager.getConnection();
		String query = "SELECT * FROM fitness "
						+ "WHERE userid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Fitness vo = null;
		
		try {
			// 문장 준비하기
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			pstmt.setString(1, id);
			
			// 문장 실행하기
			rs = pstmt.executeQuery();
			// executeQuery는 table로 반환하지만 executeUpdate는 int로 반환함 
			
			if (!rs.next()) return null; // 필수!!
			// 아이디가 존재하지 않는다면 next를 못하므로 데이터 반환 불가
			// 그럼에도 불구하고 getString하면 NullPointException 터질 수 있으므로 return null
			String userid = rs.getString(2);
			String username = rs.getString(3);
			double height = rs.getDouble(4);
			double weight = rs.getDouble(5);
			
			vo = new Fitness(userid, username, height, weight); // 생성자 : Fitness 객체 생성하는 역할

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
		
		return vo;
	}

	@Override
	public boolean update(Fitness fitness) {
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE fitness "
						+ "SET HEIGHT = ?, "
						+ "    WEIGHT = ? "
						+ "WHERE USERID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 문장 준비하기
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			pstmt.setDouble(1, fitness.getHeight());
			pstmt.setDouble(2, fitness.getWeight());
			pstmt.setString(3, fitness.getId());
			
			// 문장 실행하기
			result = pstmt.executeUpdate();
			// executeQuery는 table로 반환하지만 executeUpdate는 int로 반환함 

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
		
		if (result==1) return true;
		return false;
	}

	@Override
	public boolean delete(String id) {
		Connection conn = ConnectionManager.getConnection();
		String query = "DELETE fitness "
				+ "WHERE USERID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 문장 준비하기
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			pstmt.setString(1, id);
			
			// 문장 실행하기
			result = pstmt.executeUpdate();
			// executeQuery는 table로 반환하지만 executeUpdate는 int로 반환함 
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

		if (result==1) return true;
		return false;
	}

	@Override
	public List<Fitness> selectAll() {
		List<Fitness> list = new ArrayList<>();
		
		Connection conn = ConnectionManager.getConnection();
		String query = "SELECT * FROM fitness "
						+ "ORDER BY USERNAME";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 문장 준비하기
			pstmt = conn.prepareStatement(query); // pstmt를 반환해주는 함수
			
			// 문장 실행하기
			rs = pstmt.executeQuery();
			// executeQuery는 table로 반환하지만 executeUpdate는 int로 반환함 
			
			while (rs.next()) { // true 또는 false
				// seqno는 필요없으므로 1번은 안가져옴
				String userid = rs.getString(2);
				String username = rs.getString(3);
				double height = rs.getDouble(4);
				double weight = rs.getDouble(5);
				Fitness vo = new Fitness(userid, username, height, weight); // 생성자 : Fitness 객체 생성하는 역할
				list.add(vo); // 각 회원의 정보를 list에 담는 것
			}
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
		
		return list;
	}

}
