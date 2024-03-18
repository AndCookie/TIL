package net.kdigital.spring4.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring4.domain.Friend;

@Controller
@Slf4j

@RequestMapping("/display")
//공통된 맵핑정보는 따로 밖에 뺄 수 있다.
public class ThymeleafController {
	
	@GetMapping("/text")
	public String text(Model model) {
		// 서버에서 클라이언트로, 즉 java에서 html로 데이터를 보내고 싶을 때
		// 그것을 실어나를 객체가 바로 Model!
		log.info("문자 출력을 위한 타임리프");
		String korean = "대한민국~ ♪♬";
		String english = "America : Hello, World!";
		int num =23;
		double pi = 3.14159;
		String tag = "<marquee>돌 굴러가유~</marquee>"; // 현재는 비표준으로 없어진 태그임
		String url = "http://www.naver.com";
		
		// html은 키 값인 "kor"로 꺼내게 될 예정
		model.addAttribute("kor", korean);
		model.addAttribute("english", english);
		model.addAttribute("num", num);
		model.addAttribute("pi", pi);
		model.addAttribute("tag", tag);
		model.addAttribute("url", url);
		
		
		// ========== 객체를 생성
		Friend f = new Friend("전우치", 34, "010-1111-2222", true);
		Friend f1 = new Friend("손오공", 25, "010-2222-3333", true);
		model.addAttribute("friend", f);
		model.addAttribute("f1", f1);
		
		// ========== 숫자 데이터
		int n1 = 1_230_000;
		double n2 = 5_123_456.356424;
		double n3 = 0.5;
		double n4 = 15.45;
		model.addAttribute("inum", n1);
		model.addAttribute("dnum", n2);
		model.addAttribute("dnum2", n3);
		model.addAttribute("dnum3", n4);
	
		// ========== 날짜 데이터
		Date d = new Date();
		model.addAttribute("date", d);
		
		
		
		return "text"; // forwarding
		// model은 forwarding 방식에서만 사용해야한다!!
		// 리다이렉트의 경우 model 활용 ㄴㄴ
	}
	
	@GetMapping("/condition")
	public String condition() {
		return "condition";
	}
}


//공통된 맵핑정보는 따로 빼지 않은 원형
//public class ThymeleafController {
//	
//	@GetMapping("/display/text")
//	public String text() {
//		return "text";
//	}
//	
//	@GetMapping("/display/condition")
//	public String condition() {
//		return "condition";
//	}
//}

