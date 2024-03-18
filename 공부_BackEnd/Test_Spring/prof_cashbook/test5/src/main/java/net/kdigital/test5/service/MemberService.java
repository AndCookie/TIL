package net.kdigital.test5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.kdigital.test5.domain.Member;
import net.kdigital.test5.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	// 회원가입 + 암호화
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpw());
		member.setMemberpw(encodedPassword);  // 암호화된 비번을 세팅

		int result = mapper.insertMember(member);
		return result;
	}
}
