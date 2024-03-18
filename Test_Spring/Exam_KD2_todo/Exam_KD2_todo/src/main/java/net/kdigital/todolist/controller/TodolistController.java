package net.kdigital.todolist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.todolist.domain.Todo;
import net.kdigital.todolist.service.TodoListService;

@Controller
@Slf4j
public class TodolistController {
	
	@Autowired
	TodoListService service;

	/**
	 * 할일 목록 요청페이지
	 * @return
	 */
	@GetMapping("/todo/todolist")
	public String todolist(
			@AuthenticationPrincipal UserDetails user,
			Model model) {
		String id = user.getUsername();
		
		List<Todo> list = service.todoFindById(id);
		model.addAttribute("todolist", list); 
		log.info("조회결과 : {}", list);
		return "/todo/todolist";
	}
	
	/**
	 * 로그인 한 아이디의 모든 Todo 목록을 조회
	 * @param todoid
	 * @return
	 */
	@GetMapping("/todo/findById")
	@ResponseBody
	public List<Todo> findById(String todoid,
			@AuthenticationPrincipal UserDetails user,
			Model model) {
		
		// Code Here
		String id = user.getUsername();
		
		List<Todo> list = service.todoFindById(id);
		log.info("전체 TODO 목록 : {}", list);
		model.addAttribute("todolist", list);
		return list;
	}
	
	/**
	 * 로그인한 아이디의 todo를 저장
	 * @param todo
	 * @return
	 */
	
	@PostMapping("/todo/todoCreate")
	@ResponseBody
	public List<Todo> todoCreate(Todo todo, @AuthenticationPrincipal UserDetails user, Model model) {
		String id = user.getUsername();
		todo.setTodoid(id);
		log.info("{}", todo.toString());
		
		int result = service.todoCreate(todo);
		log.info("저장 결과 : {}", result);
		
		// 특정 id의 todo만 조회하도록 함
		List<Todo> list = service.todoFindById(id);
		model.addAttribute("todolist", list);
		log.info("조회 결과 : {}", list.toString());
		
		return list;
	}
	
	/**
	 * seqno에 해당하는 todo 삭제
	 * @param seqno
	 * @return
	 */
	
	@GetMapping("/todo/todoDelete")
	@ResponseBody
	public int todoDelete(int seqno) {
		
		// Code Here
		int result = service.todoDelete(seqno);
		
		return result;
	}
}
