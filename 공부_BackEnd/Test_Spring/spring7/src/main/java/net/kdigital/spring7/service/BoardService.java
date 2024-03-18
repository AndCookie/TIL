package net.kdigital.spring7.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kdigital.spring7.domain.Board;
import net.kdigital.spring7.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	// 게시글 개수 요청
	public int getBoardCount(String searchItem, String searchWord) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		int totalRecordCount = boardMapper.getBoardCount(map);
		return totalRecordCount;
	}

	// 게시글 등록 요청
	public int insertBoard(Board board) {
		int result = boardMapper.insertBoard(board);
		return result;
	}
	
	// 전체 게시글 목록 요청
	public List<Board> selectBoardAll(int srow, int erow, String searchItem, String searchWord) {
		Map<String, Object> map = new HashMap<>();
		map.put("srow", srow);
		map.put("erow", erow);
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		List<Board> listboard = boardMapper.selectBoardAll(map);
		return listboard;
	}

	// 게시글 1개 조회
	public Board selectBoard(int boardseq) {
		Board board = boardMapper.selectBoard(boardseq);
		boardMapper.updateHitcount(boardseq);
		return board;
	}

	// 게시글 1개 삭제
	public int deleteBoard(int boardseq) {
		int result = boardMapper.deleteBoard(boardseq);
		return result;
	}
	
	// 게시글 수정 처리
	public int updateBoard(Board board) {
		int result = boardMapper.updateBoard(board);
		return result;
	}

	// 파일 정보 삭제
	public int updateFile(int boardseq) {
		int result = boardMapper.updateFile(boardseq);
		return result;
	}


}
