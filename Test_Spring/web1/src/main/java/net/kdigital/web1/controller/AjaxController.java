package net.kdigital.web1.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.web1.domain.Friend;

@Controller
@Slf4j
public class AjaxController {
	@GetMapping("/ajaxReq1")
	@ResponseBody
	public String ajaxReq1() {
		log.info("요청 도착함!");
		
		return "도착";
		// @ResponseBody : 도착.html을 의미하는 것이 아니라 문자열을 반환하겠다는 의미!
		// 만약 @RestController 사용하면 @ResponseBody 생략 가능
	}
	
	@PostMapping("/ajaxReq2")
	@ResponseBody
	public Map<String, String> ajaxReq2(String name, String phone) {
		log.info("요청 도착함 22 : {}, {}", name, phone);
		Map<String, String> map = new HashMap<>();
		map.put("name", name+"님");
		map.put("phone", phone);
		return map;
		// map으로 전달해서 JSON으로 받는 것
	}
	
	@GetMapping("/ajaxReq3")
	@ResponseBody
	public List<String> ajaxReq3() {
		List<String> list = Arrays.asList("사과", "딸기", "복숭아", "수박", "포도");
		return list;
	}
	
	@GetMapping("/ajaxReq4")
	@ResponseBody
	public List<Friend> ajaxReq4() {
		List<Friend> list = Arrays.asList(
				new Friend(0, "손오공", "010-1111-1111", "서울시 강남구"),
				new Friend(1, "사오정", "010-2222-2222", "서울시 서초구"),
				new Friend(2, "저팔계", "010-3333-3333", "서울시 송파구")
				);
		
		return list;
	}
	
}
