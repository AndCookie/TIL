package net.kdigital.spring7.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Member;
import net.kdigital.spring7.mapper.MemberMapper;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// 회원가입 + 암호화
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpwd()); // 암호화된 비밀번호
		member.setMemberpwd(encodedPassword); // 암호화된 비번을 세팅
		
		int result = mapper.insertMember(member);
		return result;
	}

	public Member selectMember(String memberid, String memberpwd) {
		// memberpwd : 사용자가 입력한, 즉 암호화되지 않은 상태의 비번
		Map<String, String> map = new HashMap<>();
		log.info("아이디 {}", memberid);
		log.info("비번 {}", memberpwd);
		
		map.put("memberid", memberid);
		
		Member member = mapper.selectMember(map);
		System.out.println(member);
		if (memberpwd != null) {
			log.info("{}",  member.getPassword());
			boolean result = passwordEncoder.matches(memberpwd, member.getPassword());
			// member.getPassword() == member.getMemberpwd
			System.out.println(result);
			
			if (result)
				return member; // 원본 비번과 암호화된 비번이 동일한 경우
		}
		return null; // 원본 비번과 암호화된 비번이 상이한 경우
	}

	public int updateMember(Member member) {
		// 바꾼 비밀번호도 암호화 시켜야한다!!!
		String encodedPassword = passwordEncoder.encode(member.getMemberpwd()); // 암호화된 비밀번호
		member.setMemberpwd(encodedPassword); // 암호화된 비번을 세팅
		
		int result = mapper.updateMember(member);
		return result;
		
	}
	
	// 회원 아이디의 사용여부 체크
	public Member idCheck(String memberid) {
		Map<String, String> map = new HashMap<>();
		map.put("memberid", memberid);
		
		Member member = mapper.selectMember(map);
		return member;
	}
	
	
}