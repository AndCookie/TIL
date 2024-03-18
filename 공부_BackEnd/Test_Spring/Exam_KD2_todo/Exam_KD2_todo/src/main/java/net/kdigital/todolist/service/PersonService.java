package net.kdigital.todolist.service;

import net.kdigital.todolist.domain.Person;

public interface PersonService {
	// 회원 가입
	public int signup(Person person);
	
	// 아이디 중복 체크
	public Person todoidCheck(String todoid);
	
	public Person selectMember(String todoid, String todopwd);
}
