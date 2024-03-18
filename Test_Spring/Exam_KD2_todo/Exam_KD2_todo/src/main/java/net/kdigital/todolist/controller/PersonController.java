package net.kdigital.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.todolist.domain.Person;
import net.kdigital.todolist.service.PersonService;

@Controller
@Slf4j
public class PersonController {
	@Autowired
	PersonService service;
	
	/**
	 * 회원가입 화면 요청
	 * @return
	 */
	@GetMapping("/person/signup")
	public String signup() {
		return "/person/signup";
	}
	/**
	 * 로그인 화면 요청
	 * @return
	 */
	@GetMapping("/person/signin")
	public String signin() {
		return "/person/signin";
	}
	
	/**
	 * 아이디 중복여부 체크
	 * @param todoid
	 * @return
	 */
	@PostMapping("/person/todoidCheck")
	@ResponseBody
	public String todoidCheck(String todoid) {
		log.info("{}", todoid);
		Person p = service.todoidCheck(todoid);
		
		if(p == null) return "success";
		return "fail";
	}
	
	/**
	 * 회원가입 처리
	 * @param person
	 * @return
	 */
	@PostMapping("/person/regist")
	public String regist(Person person) {
		
		int result = service.signup(person);
		return "redirect:/";
	}
}
