package net.kdigital.web1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.web1.domain.Friend;
import net.kdigital.web1.service.FriendService;

@Slf4j
@Controller
public class NextpageController {
   
   @Autowired
   FriendService service;
   
   @GetMapping("/nextpage")
   public String nextpage() {
      return "nextpage";
   }
   
   @PostMapping("/friendRegist")
   @ResponseBody
   public List<Friend> regist(Friend friend) {
      //저장 후에
      service.insertFriend(friend);
      //조회하기
       List<Friend> list = service.selectFriendAll();
       return list;
   }
   
   @GetMapping("/retrieveAll")
   @ResponseBody
   public List<Friend> retrieveAll(Friend friend) {
	   // 저장 없이 조회하기
	   List<Friend> list = service.selectFriendAll();
	  
	   return list;
   }

   @GetMapping("/friendDelete")
   @ResponseBody
   public String friendDelete(int seq) {
	   log.info("번호 : {}", seq);
	   int result = service.deleteFriend(seq);
	   
	   if (result==1)
		   return "success";
	   else
		   return "fail";
   }
   
   @GetMapping("/friendSelect")
   @ResponseBody
   public Friend friendSelect(int seq) {
	   Friend friend = service.selectFriend(seq);
	   log.info("{}", friend); // friend이므로 주소값이 찍힐 것
	   // friend.toString()하면 안됩니다 : null인 경우 string 변환 불가능하므로 에러 왕창!
	   if (friend != null)
		   return friend;
	   else
		   return null;
   }
   
   @PostMapping("/friendUpdate")
   @ResponseBody
   public List<Friend> update(Friend friend) {
      //수정 후에
      service.updateFriend(friend);
      //조회하기
       List<Friend> list = service.selectFriendAll();
       return list;
       // retrieveAll로 redirect하는 방법도 있다!
   }
}