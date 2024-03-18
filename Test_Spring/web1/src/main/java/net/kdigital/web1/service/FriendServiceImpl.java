package net.kdigital.web1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.web1.domain.Friend;
import net.kdigital.web1.mapper.FriendMapper;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendMapper mapper;
	
   @Override
   public int insertFriend(Friend friend) {
      return mapper.insertFriend(friend);
   }

   @Override
   public Friend selectFriend(int seq) {
      return mapper.selectFriend(seq);
   }

   @Override
   public List<Friend> selectFriendAll() {
      return mapper.selectFriendAll();
   }

   @Override
   public int deleteFriend(int seq) {
      return mapper.deleteFriend(seq);
   }

   @Override
   public int updateFriend(Friend friend) {
      return mapper.updateFriend(friend);
   }

}