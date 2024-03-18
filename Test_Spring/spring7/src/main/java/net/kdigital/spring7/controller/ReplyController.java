package net.kdigital.spring7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Reply;
import net.kdigital.spring7.service.ReplyService;

@Controller
@Slf4j
public class ReplyController {
	
	@Autowired
	ReplyService service;
	
	@GetMapping("/board/replyAll")
	@ResponseBody
	public List<Reply> replyAll(int boardseq) {
		List<Reply> list = service.selectReplyAll(boardseq);
		log.info("{}", list.toString());
		return list;
	}
}
