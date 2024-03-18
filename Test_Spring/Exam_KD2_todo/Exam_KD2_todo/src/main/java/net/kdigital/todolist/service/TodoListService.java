package net.kdigital.todolist.service;

import java.util.List;
import java.util.Map;

import net.kdigital.todolist.domain.Todo;

public interface TodoListService {
	// todo 생성
	public int todoCreate(Todo todo);
	
	// 로그인한 사용자의 todo 목록 조회
	public List<Todo> todoFindById(String todoid);
	
	// todo 삭제
	public int todoDelete(int seqno);

}
