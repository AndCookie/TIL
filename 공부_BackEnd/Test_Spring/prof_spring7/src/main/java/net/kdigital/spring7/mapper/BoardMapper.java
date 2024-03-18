package net.kdigital.spring7.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.kdigital.spring7.domain.Board;

@Mapper
public interface BoardMapper {
	// 게시 글개수 조회
	public int getBoardCount(Map<String, Object> map);

	// 게시글 등록
	public int insertBoard(Board board);

	// 게시글 목록 요청
	public List<Board> selectBoardAll(Map<String, Object> map);

	// 게시글 1개 요청
	public Board selectBoard(int boardseq);

	// 게시글 삭제 요청
	public int deleteBoard(int boardseq);

	// 게시글 수정처리 요청
	public int updateBoard(Board board);
	
	
	// 게시글 조회수 증가
	public int updateHitcount(int boardseq);

	// 게시글 중 파일관련 정보만 삭제
	public int updateFile(int boardseq);

}








