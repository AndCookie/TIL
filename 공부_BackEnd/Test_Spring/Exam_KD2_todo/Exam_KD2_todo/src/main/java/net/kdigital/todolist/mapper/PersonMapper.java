package net.kdigital.todolist.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import net.kdigital.todolist.domain.Person;

@Mapper
public interface PersonMapper {
	//회원 가입
	public int signup(Person person);

	// 이메일 또는 닉네임 중복 체크
	public Person todoidCheck(String todoid);
	
	public Person selectMember(Map<String, String> map);
}
