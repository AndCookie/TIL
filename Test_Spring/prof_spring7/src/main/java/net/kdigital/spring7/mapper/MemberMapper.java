package net.kdigital.spring7.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.spring7.domain.Member;

@Mapper
public interface MemberMapper {

	public int insertMember(Member member);

}
