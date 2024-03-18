package net.kdigital.todolist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.todolist.domain.Todo;
import net.kdigital.todolist.mapper.TodoListMapper;

@Service
public class TodoListServiceImpl implements TodoListService {
	
	@Autowired
	TodoListMapper mapper;
	
	@Override
	public List<Todo> todoFindById(String todoid) {
		List<Todo> list = mapper.todoFindById(todoid);
		return list;
	}
	
	@Override
	public int todoCreate(Todo todo) {
		int result = mapper.todoCreate(todo);
		return result;
	}

	@Override
	public int todoDelete(int seqno) {
		int result = mapper.todoDelete(seqno);
		return result;
	}
}
