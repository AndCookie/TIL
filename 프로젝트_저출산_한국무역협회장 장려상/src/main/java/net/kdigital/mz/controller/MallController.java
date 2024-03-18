package net.kdigital.mz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MallController {
	
	@GetMapping("/mall")
	public String mall() {
		return "/mall";
	}
}
