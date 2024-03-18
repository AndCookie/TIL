package net.kdigital.todolist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.todolist.domain.Person;
import net.kdigital.todolist.mapper.PersonMapper;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	// 회원가입 + 암호화
	public int signup(Person person) {
		String encodedPassword = passwordEncoder.encode(person.getTodopwd()); // 암호화된 비밀번호
		person.setTodopwd(encodedPassword); // 암호화된 비번을 세팅
		
		int result = mapper.signup(person);
		return result;
	}
	
	@Override
	public Person selectMember(String todoid, String todopwd) {
		// todopwd : 사용자가 입력한, 즉 암호화되지 않은 상태의 비번
		Map<String, String> map = new HashMap<>();
		log.info("아이디 {}", todoid);
		log.info("비번 {}", todopwd);
		
		map.put("todoid", todoid);
		
		Person person = mapper.selectMember(map);
		System.out.println(person);
		if (todopwd != null) {
			log.info("{}",  person.getPassword());
			boolean result = passwordEncoder.matches(todopwd, person.getPassword());
			// person.getPassword() == person.getMemberpwd
			System.out.println(result);
			
			if (result)
				return person; // 원본 비번과 암호화된 비번이 동일한 경우
		}
		return null; // 원본 비번과 암호화된 비번이 상이한 경우
	}

	@Override
	public Person todoidCheck(String todoid) {
		Map<String, String> map = new HashMap<>();
		map.put("todoid", todoid);
		Person p = mapper.selectMember(map);
		
		return p;
	}
}
