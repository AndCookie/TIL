// KD2기 이름: 이선재


package net.kdigital.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"/", ""})
	public String index() {
		return "index";
	}
}
