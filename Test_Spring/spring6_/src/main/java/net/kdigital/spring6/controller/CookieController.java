
package net.kdigital.spring6.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CookieController {
	
	@GetMapping("/cookieSave")
	public String cookieSave(HttpServletResponse response) {
		Cookie cookie1 = new Cookie("test1", "1111");
		Cookie cookie2 = new Cookie("test2", "2222");
		Cookie cookie3 = new Cookie("test3", "3333");
		// 기본 생성자로 생성 불가
		// 전달인자로 키와 벨류의 쌍(String name, String value)이 필요하다
		// HttpServletResponse response : 달라고 요청하기
		
		
		// 클라이언트에 쿠키 정보가 유지되는 시간 설정
		cookie1.setMaxAge(24*60*60);
		cookie2.setMaxAge(24*60*60);
		cookie3.setMaxAge(24*60*60);
		// 쿠키 정보를 몇 초동안 유지 및 기억하도록 할 것인가?
		// 하루 = 24시간*60분*60초
		// 바로 즉시 = 0
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		
		// 서버가 클라이언트 쪽으로 정보를 응답하고자할 때 사용
		return "cookieResult";
	}
	
	@GetMapping("/cookieDel")
	public String cookieDel(HttpServletResponse response) {
		Cookie cookie1 = new Cookie("test1", null);
		Cookie cookie2 = new Cookie("test2", null);
		Cookie cookie3 = new Cookie("test3", null);
		// null이 오버라이팅 되도록 함
		
		// 클라이언트에 쿠키 정보가 유지되는 시간 설정
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		cookie3.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/cookieRead")
	public String cookieRead(
			@CookieValue(name="test1", defaultValue="쿠키없음") String temp1,
			@CookieValue(name="test2", defaultValue="None") String temp2,
			@CookieValue(name="test4", defaultValue="이런 쿠키 없음") String temp4
			) {
		log.info("첫 번째 쿠키값 : {}", temp1);
		log.info("두 번째 쿠키값 : {}", temp2);
		log.info("네 번째 쿠키값 : {}", temp4);
		
		
		return "redirect:/";
	}
	
}
