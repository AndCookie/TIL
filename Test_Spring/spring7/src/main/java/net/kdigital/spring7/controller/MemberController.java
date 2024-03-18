package net.kdigital.spring7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Member;
import net.kdigital.spring7.service.MemberService;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	MemberService service;
	
	/**
	 * 회원 가입을 위한 화면 요쳥
	 * @return
	 */
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	/**
	 * 회원가입 처리 요청
	 * @param member
	 * @return
	 */
	@PostMapping("/signup")
	public String signup(Member member) {
		log.info("회원정보: {}", member.toString());
		
		// DB와 연동해서 데이터 저장
		service.insertMember(member);
		return "redirect:/";
	}
	
	/**
	 * 로그인을 위한 화면 요쳥
	 * @return
	 */
	@GetMapping("/signin")
	public String signin() {
		return "/member/signin";
	}
	
	/**
	 * 비번 체크 화면 요청
	 * => 이미 로그인이 된 상태이므로 securitycontext에서 조회 가능
	 * @return
	 */
	@GetMapping("/mypage")
	public String mypage(@AuthenticationPrincipal UserDetails user, Model model) {
		Member member = service.selectMember(user.getUsername(), null); // getUsername:시큐리티에서 사용하는 아이디
		model.addAttribute("member", member);
		return "/member/pwdcheck";
	}
	
	/**
	 * DB에서 정보를 가져옴
	 * @return
	 */
	@PostMapping("/pwdcheck")
	public String pwdcheck(String memberid, String memberpwd, Model model) {
		Member m = service.selectMember(memberid, memberpwd);
	
		if (m != null) {
			// 수정하는 화면으로 이동
			String email = m.getEmail();
			String m1 = email.split("@")[0];
			String m2 = email.split("@")[1];
			String phone = m.getPhone();
			String p1 = phone.substring(0,3);
			String p2 = phone.substring(3,7);
			String p3 = phone.substring(7);
			
			model.addAttribute("member", m);
			model.addAttribute("m1", m1);
			model.addAttribute("m2", m2);
			model.addAttribute("p1", p1);
			model.addAttribute("p2", p2);
			model.addAttribute("p3", p3);
			
			return "/member/mypage";
		} else {
			// 첫 화면으로 이동
			return "redirect:/";
		}
	}
	
	/**
	 * 회원정보 수정 처리 요청
	 * @param member
	 * @return
	 */
	@PostMapping("/modify")
	public String modify(@AuthenticationPrincipal UserDetails user, Member member) {
		member.setMemberid(user.getUsername());
		log.info("회원정보 : {}", member.toString());
		
		service.updateMember(member);
		return "redirect:/logout";
		// logout : security에서 만든 것 (WebSecurityConfig.java 참조)
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String idCheck(String memberid) {
		Member member = service.idCheck(memberid);
		if (member == null)
			return "success";
		else
			return "fail";
	}
	
	
	
}