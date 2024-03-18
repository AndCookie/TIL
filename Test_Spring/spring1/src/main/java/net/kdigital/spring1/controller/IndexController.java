package net.kdigital.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/") // 유저가 /를 요청하면
	// 사실상 localhost:8889/spring1/을 요청한 것인데 생략된 것 
	public String index() {
		// index가 의미하는 것: index.html
		// index.html 만드는 법 : src/main/resources > templates
		System.out.println("요청을 받음");
		return "index"; // index.html 문서로 응답함
	}
}
