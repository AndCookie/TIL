package net.kdigital.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StaticController {
	
	@GetMapping("/image")
	public String image() {
		return "image";
		// sysout 쓰지 말기!!
		// 대신 Slf4j 사용 (=로그 / 파일로 저장 가능)
	}
	
	@GetMapping("/css")
	public String css() {
		return "css";
	}
	
	@GetMapping("/js")
	public String js() {
		return "js";
	}
}
