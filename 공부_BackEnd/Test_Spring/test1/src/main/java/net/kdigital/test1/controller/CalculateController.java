package net.kdigital.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalculateController {
	
	@GetMapping("/calc")
	public String calc(int x, int y, Model model) {
		// 서버에서 클라이언트로, 즉 java에서 html로 데이터를 보내고 싶을 때
		// 그것을 실어나를 객체가 바로 Model!
		int z= x+y;
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("z", z);
		return "result";
	}

}
