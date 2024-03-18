package net.kdigital.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/refer")
@Slf4j
public class ReferController {
//	@Autowired
//	ReferService referService;
	
	
	@GetMapping("/refer")
	public String refer() {
		return "/refer/refer";
	}
}
