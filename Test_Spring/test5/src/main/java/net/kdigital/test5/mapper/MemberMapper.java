package net.kdigital.test5.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.test5.domain.Member;

@Mapper
public interface MemberMapper {

	public int insertMember(Member member);

}