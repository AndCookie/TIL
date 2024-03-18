package net.kdigital.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import net.kdigital.test2.domain.Person;

@Controller
public class PersonController {
	@PostMapping("/info")
	public String calc(Person p, Model model) {
		
		int age = 2023-p.getYear();
		p.setAge(age);
		
		model.addAttribute("person", p);
		
		return "result";
	}
}
