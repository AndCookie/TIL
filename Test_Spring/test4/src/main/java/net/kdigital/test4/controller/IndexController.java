package net.kdigital.test4.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/visit")
	public String visit(@CookieValue(name="count", defaultValue="0") String count,
						HttpServletResponse response, Model model)
						// @CookieValue : 쿠키 값을 받아오고자 할 때
						// HttpServletResponse : 서버에서 클라이언트 쪽으로 정보를 저장 또는 전달하고자 할 때 만드는 객체
						// Model : server=>client로, 즉 어떤 값을 모델에 담아서 전달해야 html에서 해석이 가능하다
						{			
		count = (Integer.parseInt(count) + 1) + "";
		// Integer.parseInt : 문자열을 숫자로 만들기
		// ""빈 문자열을 더하면 문자가 된다 => 쿠키는 문자열 밖에 못쓰니까
		
		Cookie cookie = new Cookie("count", count);
		cookie.setMaxAge(24*60*60); // 초단위로 유지 기간 지정
		
		response.addCookie(cookie); // 담는 순간 클라이언트에 전달되어 저장됨
		model.addAttribute("count", count); // 
		
		return "visit";
	}
	
	@GetMapping("/del")
	public String del( HttpServletResponse response)
						// HttpServletResponse : 
						{
		Cookie cookie = new Cookie("count", null);
		cookie.setMaxAge(0); // 초 단위로 기간을 정함
		response.addCookie(cookie);
		
		return "redirect:/";
	}

}