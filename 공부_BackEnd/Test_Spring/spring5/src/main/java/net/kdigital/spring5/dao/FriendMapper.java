package net.kdigital.spring5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import net.kdigital.spring5.domain.Friend;

@Mapper 
// session 요청하고~ 어쩌고 안해도 됨! @Mapper로 끝
public interface FriendMapper {
	public int insertFriend(Friend friend);
	// 됐다 아니다를 1과 0으로 반환하므로 int
	public List<Friend> selectAll();
	// 친구 목록을 반환하므로 List
	
	// 두 개의 창이 필요하다 : 친구 목록을 생성하는 입력창과 생성된 것을 한꺼번에 보여주는 창
	// ==> index.html 만들러 가기
}
