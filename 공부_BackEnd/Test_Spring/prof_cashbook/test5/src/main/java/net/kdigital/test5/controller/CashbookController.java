package net.kdigital.test5.controller;

import java.util.List;

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
	
	@PostMapping("/insert")
	public String insert(
			Cashbook cashbook, 
			@AuthenticationPrincipal UserDetails user) {
		
		String id = user.getUsername();
		cashbook.setMemberid(id);
		
		log.info("{}", cashbook.toString());
		
		int result = service.insertCash(cashbook);
		
		log.info("저장결과: {}", result);
		
		return "redirect:/cash/cashbook";
	}
}
