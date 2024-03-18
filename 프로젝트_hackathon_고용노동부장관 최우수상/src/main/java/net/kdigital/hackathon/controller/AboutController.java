package net.kdigital.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.hackathon.service.PortService;

@Controller
@RequestMapping("/about")
@Slf4j
public class AboutController {
//	@Autowired
//	AboutService aboutService;
	
	
	@GetMapping("/about")
	public String about() {
		return "/about/about";
	}
}
