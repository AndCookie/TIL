package net.kdigital.spring7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.kdigital.spring7.domain.Member;
import net.kdigital.spring7.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// 회원가입 + 암호화
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpwd());
		member.setMemberpwd(encodedPassword);  // 암호화된 비번을 세팅
		
		int result = mapper.insertMember(member);
		return result;
	}
}







