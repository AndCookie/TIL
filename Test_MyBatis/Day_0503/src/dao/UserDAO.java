package dao;

import java.util.List;

import vo.User;

public interface UserDAO {
	/**
	 * 회원정보 저장
	 * @param user
	 * @return 저장 여부 (1: 1명이 등록, 0 : 등록안됨)
	 */
	public int insertUser(User user);
	/**
	 * 회원 전체 정보 조회
	 * @return 목록(List)에 담긴 모든 회원의 정보
	 */
	public List<User> selectAll();
	/**
	 * 한 사람의 회원 정보 조회
	 * @param userid : 조회할 회원의 아이디 (PK)
	 * @return 회원의 정보가 담긴 User 객체
	 */
	public User selectOne(String userid);
	
}
/*
 * INSERT INTO userinfo
 * (USERID, USERNAME, GENDER, PHONE, BIRTHDAY)
 * VALUES
 * ('hong', '홍길동', '남', '010-1111-2222', '2019-01-01')
 */
/*
 * SELECT
 * 	   USERID, USERNAME, GENDER, PHONE,
 * 	   to_char(BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY (setBirthday를 찾기위해서는 AS 필수!!!)
 * FROM userinfo
 * ORDER BY username
 * (* 별 하나가 setter를 의미하는데 date 타입인 birthday를 java에서는 string으로 선언해뒀으므로 따로따로 만들어줘야 함)
 */
