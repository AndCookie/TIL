package net.kdigital.spring6.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SessionController {
	
	@GetMapping("/sessionSave")
	public String sessionSave(HttpSession session) {
		// 아이디abc/이름홍길동/나이24 로 로그 기록이 있다고 가정
		session.setAttribute("loginId", "abc");
		session.setAttribute("loginName", "홍길동");
		session.setAttribute("loginAge", 24);
		// loginId & loginName : 서버쪽 개발자가 붙이는 이름
		
		return "sessionView";
	}

	@GetMapping("/sessionDel")
	public String sessionDel(HttpSession session) {
		// 한 번에 삭제
		session.invalidate();
		
		// 세 번에 걸쳐서 삭제
//		session.removeAttribute("loginId");
//		session.removeAttribute("loginName");
//		session.removeAttribute("loginAge");
		
		return "redirect:/";
	}

	@GetMapping("/sessionRead")
	public String sessionRead(HttpSession session) {
		// 세션에 저장된 정보를 꺼내옴
		// 반환타입이 Object이므로 처음 저장했던 타입으로 하향 캐스팅
		String id = (String) session.getAttribute("loginId");
		String name = (String) session.getAttribute("loginName");
		// (String) : getAttribute의 반환타입은 object이므로 다운캐스팅!!!
		int age = (Integer)session.getAttribute("loginAge");
		// (Integer) : getAttribute의 반환타입은 object이므로 다운캐스팅!!!
		
		log.info("로그인 아이디 {}", id);
		log.info("로그인 이름 {}", name);
		log.info("로그인 나이 {}", age);
		
		return "redirect:/";
		
		// 세션 정보는 클라이언트 쪽에서도 확인 가능하다!
	}
}
