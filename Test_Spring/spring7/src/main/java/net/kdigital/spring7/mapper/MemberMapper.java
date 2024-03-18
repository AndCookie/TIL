package net.kdigital.spring7.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.spring7.domain.Member;

@Mapper
public interface MemberMapper {

	public int insertMember(Member member);

	public Member selectMember(Map<String, String> map);

	public int updateMember(Member member);

}
