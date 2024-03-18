package net.kdigital.test3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.test3.domain.Guestbook;
import net.kdigital.test3.mapper.GuestbookMapper;

@Service
public class GuestbookSerivce {

	@Autowired
	GuestbookMapper mapper;
	
	public int writeGuestbook(Guestbook guestbook) {
		int result = mapper.insertGuestbook(guestbook);
		return result;
	}

	public List<Guestbook> readGuestbook() {
		List<Guestbook> list = mapper.selectAll();
		return list;
	}
	
	public int deleteGuestbook(int seq, String usrpwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		map.put("usrpwd", usrpwd);
		int result = mapper.deleteGuestbook(map);
		return result;
	}
}
