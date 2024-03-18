package net.kdigital.mz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TalkController {
	
	@GetMapping("/talk")
	public String talk() {
		return "/talk";
	}
}
