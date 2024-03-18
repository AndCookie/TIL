package net.kdigital.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.spring5.dao.FriendMapper;
import net.kdigital.spring5.domain.Friend;


@Service
public class FriendService {

	@Autowired
	FriendMapper mapper;
	public int insertFriend(Friend friend) {
		int result = mapper.insertFriend(friend);
		return result;
	}
	public List<Friend> selectAll() {
		List<Friend> list = mapper.selectAll();
		// Oracle의 list를 가져오려면 매퍼에 요청해야함
		return list;
	}

}
