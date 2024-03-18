package net.kdigital.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	@GetMapping({"/", ""})
	public String index() {
		log.info("index 요청");
		// Slf4j는 log를 찍기위한 장치
		return "index";
	}
}
