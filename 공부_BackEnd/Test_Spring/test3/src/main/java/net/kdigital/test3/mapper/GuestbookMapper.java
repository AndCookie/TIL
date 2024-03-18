package net.kdigital.test3.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.test3.domain.Guestbook;

@Mapper
public interface GuestbookMapper {
	
	public int insertGuestbook(Guestbook guestbook);
	public List<Guestbook> selectAll();
	public int deleteGuestbook(Map<String, Object> map);
	// Object는 String과 int를 모두 담을 수 있는 데이터 타입
}
