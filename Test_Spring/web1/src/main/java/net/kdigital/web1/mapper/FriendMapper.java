package net.kdigital.web1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.web1.domain.Friend;

@Mapper
public interface FriendMapper {
   public int insertFriend(Friend friend);
   public Friend selectFriend(int seq);
   public List<Friend> selectFriendAll();
   public int deleteFriend(int seq);
   public int updateFriend(Friend friend);
}