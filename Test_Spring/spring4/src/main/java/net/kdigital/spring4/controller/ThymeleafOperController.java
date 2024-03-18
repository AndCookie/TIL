package net.kdigital.spring4.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.kdigital.spring4.domain.Friend;

@Controller
@RequestMapping("/display")
public class ThymeleafOperController {
	
	@GetMapping("/operate")
	public String Operate(Model model) {
		int num = 25;
	    Friend f = new Friend("사오정", 21, "1111", false);
	    
	    // ---------- 리스트에 저장된 친구 목록 데이터를 출력
	    List<Friend> friendList = new ArrayList<>();
	    friendList.add(new Friend("손오공", 22, "2222", true));
	    friendList.add(new Friend("저팔계", 21, "3333", false));
	    friendList.add(new Friend("전우치", 23, "4444", true));
	    friendList.add(new Friend("임꺽정", 25, "5555", false));	    
	    friendList.add(new Friend("홍길동", 24, "6666", true));
	    
	    model.addAttribute("num", num);
	    model.addAttribute("f", f); // 사오정은 내성적이다! 출력하기
	    model.addAttribute("friendList", friendList);
		
		return "operate";
	}
}