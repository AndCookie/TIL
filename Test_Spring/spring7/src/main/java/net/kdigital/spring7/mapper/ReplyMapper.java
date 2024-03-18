package net.kdigital.spring7.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.spring7.domain.Reply;

@Mapper
public interface ReplyMapper {
	List<Reply> selectReplyAll(int boardseq);
}
