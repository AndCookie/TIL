package net.kdigital.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring3.domain.Member;

@Slf4j
@Controller
public class ParamController {
	
	@GetMapping("/param/input1")
	public String param(
						@RequestParam(name="name", defaultValue="아무개씨") String name,
						@RequestParam(name="age", defaultValue="19") int age
						// 물음표 앞에 있는 것이 GetMapping이고
						// 물음표 뒤에 있는 것이 QueryString이다
						) {
		System.out.printf("전송된 데이터 - 이름: %s, 나이: %d%n", name, age);
		// 로그 찍어보기
		log.info("데이터 전송받음");
		return "result";
	}
	// <web server측 응답의 두 가지 방법>
	// 1. 포워딩 // return "index"; // Web Server가 최종적으로 보게 될 문서명을 지정하여 Client에게 보여주는 것
	// 2. 리다이렉트 // return "redirect" // web server가 client로 하여금 다시 요청하도록 조치하는 것
				  // return "redirect: /" // '루트'를 다시 요청하라는 의미 -->  GetMappint("/")의 return "index"이므로 어쨋든 제일 마지막에는 포워딩으로 끝나게 되어있다

	@GetMapping("/param/view1")
	public String view() {
		// 메소드명 view는 임의로 바꿔도 된다
		return "view";
	}
	
	@GetMapping("/param/info")
	// public String info(String userid, String userpwd, String username, String gender) {
	// 매번 쓰기 귀찮으니까 java쪽에다가 VO 만든 후
	public String info(Member member) {
		log.info("이름: {} / 아이디: {} ",
				member.getUsername(), member.getUserid());
		log.info("전체 정보 : {}", member.toString());
		System.out.printf("이름: %s, 아이디: %s%n", member.getUsername(), member.getUserid());
		// 로그 사용의 이점 : 디버깅 하기가 용이하다!
		log.debug("이름: {} / 아이디: {} ",
				member.getUsername(), member.getUserid());
		return "redirect:/";
	}

}
