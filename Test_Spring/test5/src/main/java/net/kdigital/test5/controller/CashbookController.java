package net.kdigital.test5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.test5.domain.Cashbook;
import net.kdigital.test5.service.CashbookService;

@Controller
@RequestMapping("/cash")
@Slf4j
public class CashbookController {

	@Autowired
	CashbookService service;
	
	/**
	 * 가계부 화면 요쳥
	 * @return
	 */
	@GetMapping("/cashbook")
	public String cashbook(
			@AuthenticationPrincipal UserDetails user,
			Model model) {
		String id = user.getUsername();
		
		List<Cashbook> list = service.selectAll(id);
		
		log.info("조회결과 : {}", list);
		
		model.addAttribute("list", list); 
		return "/cashbook/cashbook"; 
	}
	
	/**
	 * 가계부 등록
	 * @param cashbook
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(Cashbook cashbook, @AuthenticationPrincipal UserDetails user, Model model) {
		String id = user.getUsername();
		cashbook.setMemberid(id);
		log.info("{}", cashbook.toString());
		
		int result = service.insertCash(cashbook);
		log.info("저장 결과 : {}", result);
		
		// 특정 id의 가계부만 조회하도록 함
		List<Cashbook> list = service.selectAll(id);
		model.addAttribute("list", list);
		log.info("조회 결과 : {}", list.toString());
		
		return "redirect:/cash/cashbook";
	}
	
	@GetMapping("/statistics")
	public String statistics(
			@AuthenticationPrincipal UserDetails user,
			Model model) {
		String id = user.getUsername();
		
		Map<String, Integer> map = service.statistics(id);
		
		log.info("통계 결과 : {}", map);
		
		model.addAttribute("statistics", map);
		return "/cashbook/statistics"; 
	}
	
	
	
}
