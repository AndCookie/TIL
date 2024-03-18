package net.kdigital.spring6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String usrid, String usrpwd, HttpSession session) {
		// DB에서 정보를 얻어왔다고 가정
		session.setAttribute("loginId", usrid);
		session.setAttribute("loginName", "전우치");
		return "loginResult";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 한 번에 삭제
		session.invalidate();
		return "loginResult";
	}
}
