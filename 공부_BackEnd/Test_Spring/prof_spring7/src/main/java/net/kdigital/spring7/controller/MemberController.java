package net.kdigital.spring7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Member;
import net.kdigital.spring7.service.MemberService;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

	@Autowired
	MemberService service;
	
	/**
	 * 회원 가입을 위한 화면 요청
	 * @return
	 */
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	/**
	 * 회원가입 처리 요청
	 * @param member
	 * @return
	 */
	@PostMapping("/signup")
	public String signup(Member member) {
		log.info("회원정보: {}", member.toString());
		
		service.insertMember(member);
		
		return "redirect:/";
	}
	
	/**
	 * 로그인을 위한 화면 요청
	 * @return
	 */
	@GetMapping("/signin")
	public String signin() {
		return "/member/signin";
	}
	
}
