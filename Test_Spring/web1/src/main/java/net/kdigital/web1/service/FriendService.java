package net.kdigital.web1.service;

import java.util.List;

import net.kdigital.web1.domain.Friend;

public interface FriendService {   
   public int insertFriend(Friend friend);
   public Friend selectFriend(int seq);
   public List<Friend> selectFriendAll();
   public int deleteFriend(int seq);
   public int updateFriend(Friend friend);
}