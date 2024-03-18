package net.kdigital.spring4.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.kdigital.spring4.domain.Friend;

@Controller
public class ThymeCollectController {
	@GetMapping("/display/collection")
	public String collection(Model model) {
		List<String> list = Arrays.asList("사과", "배", "오렌지", "딸기");
		System.out.println(list.toString());
		// sysout(list) 와 sysout(list.toString())은 동일하다
		
		Map<Integer, Friend> map = new HashMap<>();
		map.put(1, new Friend("손오공", 22, "111", true));
		map.put(2, new Friend("사오정", 23, "222", false));
		map.put(3, new Friend("저팔계", 24, "333", true));
		
		List<Integer> nList = new ArrayList<>();
		for (int i=1; i<=20; ++i) {
			nList.add(i*3);
		}

		model.addAttribute("list", list);
		model.addAttribute("map", map);
		model.addAttribute("nList", nList);
		
		return "collection";
	}
	
}