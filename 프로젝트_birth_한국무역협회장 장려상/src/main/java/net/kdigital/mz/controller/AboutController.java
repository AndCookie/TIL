package net.kdigital.mz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AboutController {
	
	@GetMapping("/about")
	public String about() {
		return "/about";
	}
}
