package net.kdigital.test3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.test3.domain.Guestbook;
import net.kdigital.test3.service.GuestbookSerivce;

@Controller
@Slf4j
public class GuestbookController {
	
	@Autowired
	GuestbookSerivce service;
	// 클래스명과 reference 변수
	
	/*
	 * 방명록 기록을 위한 화면 요청
	 */
	@GetMapping("/write")
	public String write() {
		return "guestbook/write";
	}
	
	/*
	 * 전달받은 guestbook을 DB에 저장 요청
	 */
	@PostMapping("/write")
	public String write(Guestbook guestbook) {
		int result = service.writeGuestbook(guestbook);
		// 매퍼를 통해 DB와 연동해야함
		// insertFriend 만들러 controller 바로 뒷단인 service로 가기
		log.info("{}", result);
		log.info("입력결과: {}", guestbook.toString());
		return "redirect:list";
		// redirect는 GET 방식으로만 된 것만 가능하므로 list가 Get방식이라는 것을 알고 있어야 함
	}
	
	@GetMapping("/list")
	public String read(Model model) {
		List<Guestbook> list = service.readGuestbook();		
		log.info("{}", list);
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@GetMapping("/guestbookDelete")
	public String guestbookDelete(int seq, String usrpwd) {
		int result = service.deleteGuestbook(seq, usrpwd);
		log.info("{}", result);
		return "redirect:list";
	}
	
	@PostMapping("/guestbookDelete")
	public String guestbookDel(int seq, String usrpwd) {
		int result = service.deleteGuestbook(seq, usrpwd);
		log.info("{}", result);
		log.info("POST 방식 : {}, {}, seq, usrpwd");
		return "redirect:list";
	}
}
