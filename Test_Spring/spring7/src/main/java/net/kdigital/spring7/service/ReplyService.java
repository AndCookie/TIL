package net.kdigital.spring7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.spring7.domain.Reply;
import net.kdigital.spring7.mapper.ReplyMapper;

@Service
public class ReplyService {

	@Autowired
	ReplyMapper mapper;
	
	public List<Reply> selectReplyAll(int boardseq) {
		List<Reply> list = mapper.selectReplyAll(boardseq);
		return list;
	}

}
