package net.kdigital.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring5.domain.Friend;
import net.kdigital.spring5.service.FriendService;

@Controller
@Slf4j
public class FriendController {
	
	/*
	 * 예전에는 new로 객체 생성했었는데,
	 * 이제는 @Autowired를 통해 service에서 미리 준비해둔 객체를 전달해달라고 요청함
	 * 그럼 Service에서도 @Serivce가 있으니까 서로 연결되어 있으므로 전달해줌!
	 */
	@Autowired
	FriendService service;
	
	
	/*
	 * 데이터 입력을 위한 화면 요청
	 * @return
	 */
	@GetMapping("/insert")
	public String insert() {
		return "insertForm";
	}
	
	/*
	 * get/post의 방식이 다르므로 /insert가 같은 것은 괜찮지만
	 * 메소드명은 다르게 해야하며 굳이 똑같이 하고 싶다면 오버로딩 하기
	 */
	@PostMapping("/insert")
	public String insert(Friend friend) {
		// 저장 후
		int result = service.insertFriend(friend);
			// 매퍼를 통해 DB와 연동해야함 (매퍼에서 반환하는 것은 int)
			// insertFriend 만들러 service로 가기 
		log.info("결과: {}", result);
		return "redirect:/"; // 고쳐야 함
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Friend> list = service.selectAll();
		// Controller 뒷단에 있는 Serivce에 요청함
		model.addAttribute("list", list);
		// model이 있으면 무조건 forwarding 방식!!
		return "list";
	}
	
}
