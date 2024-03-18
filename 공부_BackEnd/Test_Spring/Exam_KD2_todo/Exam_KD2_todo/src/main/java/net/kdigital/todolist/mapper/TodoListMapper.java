package net.kdigital.todolist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.todolist.domain.Todo;

@Mapper
public interface TodoListMapper {
	public int todoCreate(Todo todo);
	public List<Todo> todoFindById(String todoid);
	public Todo todoFindByType(Map<String, Object> map);
	public int todoDelete(int seqno);
}