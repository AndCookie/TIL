package net.kdigital.spring7.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Board;
import net.kdigital.spring7.service.BoardService;
import net.kdigital.spring7.util.FileService;
import net.kdigital.spring7.util.PageNavigator;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	@Value("${user.board.page}")
	int countPerPage;

	@Value("${user.board.group}")
	int pagePerGroup;

	@Value("${spring.servlet.multipart.location}")
	String uploadPath;

	@Autowired
	BoardService boardService;

	/**
	 * 글 목록 요청
	 * @param model
	 * @return
	 */
	@GetMapping("/listboard")
	public String listboard(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="title") String searchItem,
			@RequestParam(value="searchWord", defaultValue="") String searchWord,
			Model model) {

		int totalRecordCount = boardService.getBoardCount(searchItem, searchWord);
		
		PageNavigator navi 
		  = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordCount);
		
		
		List<Board> listboard = boardService.selectBoardAll(
				navi.getStartRecord(),
				navi.getEndRecord(),
				searchItem, 
				searchWord);
		
		// log.info("글 목록: {}",  listboard); // 여기를 확인하시오!

		model.addAttribute("totalRecordCount", totalRecordCount);
		model.addAttribute("listboard", listboard);
		model.addAttribute("navi", navi);
		
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchWord", searchWord);

		return "/board/listboard";
	}
	/**
	 * 게시글 쓰기 위한 화면 요청
	 * @return
	 */
	@GetMapping("/writeboard")
	public String writeboard() {
		return "/board/writeboard";
	}

	/**
	 * 게시글 DB 등록 요청 (파일 첨부가능)
	 * @param board
	 * @return
	 */
	@PostMapping("/writeboard")
	public String writeboard(
			Board board, 
			MultipartFile upload, 
			Model model) {

		String originalfile = null;
		String savedFileName = null;

		if(!upload.isEmpty()) {
			originalfile = upload.getOriginalFilename();
			savedFileName = FileService.saveFile(upload, uploadPath);
		}	

		board.setOriginalfile(originalfile);
		board.setSavedfile(savedFileName);


		int result = boardService.insertBoard(board); // 데이터 입력

		return "redirect:/board/listboard";
	}

	/**
	 * 글 1개 조회
	 * @param boardseq: 조회하려는 글의 PK 
	 * @param model
	 * @return
	 */
	@GetMapping("/readboard")
	public String readboard(int boardseq, Model model) {
		// boardseq에 해당하는 1개의 글을 DB에서 조회
		log.info("조회글 번호: {}", boardseq);

		Board board = boardService.selectBoard(boardseq);
		log.info("조회된 글: {}", board.toString());

		model.addAttribute("board", board);

		return "/board/readboard";
	}

	/**
	 * 글 삭제
	 * @param boardseq: 삭제하려는 글의 PK
	 * @return
	 */
	@GetMapping("/deleteboard")
	public String deleteboard(int boardseq) {
		log.info("조회글 번호: {}", boardseq);

		// 삭제하려는 레코드를 먼저 읽어옴
		Board board = boardService.selectBoard(boardseq);

		String savedfile = board.getSavedfile();

		if(savedfile != null) {
			String fullPath = uploadPath + "/" + savedfile;
			FileService.deleteFile(fullPath);
		}

		int result = boardService.deleteBoard(boardseq);

		return "redirect:/board/listboard";
	}

	/**
	 * 글 수정을 위한 화면: 조회를 먼저 진행
	 * @param boardseq: 수정하려는 글의 PK
	 * @return
	 */
	@GetMapping("/updateboard")
	public String updateboard(int boardseq, Model model) {
		Board board = boardService.selectBoard(boardseq);

		model.addAttribute("board", board);


		return "/board/updateboard";
	}
	/**
	 * 글 수정 처리 요청
	 * @param board: 수정을 하려는 데이터
	 * @param model
	 * @return
	 */
	@PostMapping("/updateboard")
	public String updateboard(Board board, MultipartFile upload) {
		log.info("수정데이터=1: {}", board.toString());

		Board oldBoard = null;

		String oldSavedfile = null;	// 원래 파일명 
		String newSavedfile = null;    // 새롭게 첨부된 파일명

		// 기존에 파일이 첨부되어 있고,  
		// 업로드한 파일이 있으면 기존파일을 읽어서 HDD에 저장된 파일명을 보관(oldSavedfile)
		if(upload != null && !upload.isEmpty()) {
			oldBoard = boardService.selectBoard(board.getBoardseq()); // DB로부터 저장된 게시글을 가져옴
			oldSavedfile = (oldBoard == null) ? null : oldBoard.getSavedfile(); // 기존에 저장한 파일명

			// 새로운 파일 저장, DB에 수정할 준비 완료
			newSavedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(newSavedfile);
			board.setOriginalfile(upload.getOriginalFilename());

		}
		log.info("수정하는 데이터: {}", board.toString());
		int result = boardService.updateBoard(board);  // DB에 저장된 데이터를 수정을 함

		// 업데이트를 잘하고, 업로드된 파일이 있다면 기존 파일 삭제
		if(result == 1 && newSavedfile != null) {
			FileService.deleteFile(uploadPath + "/" + oldSavedfile);
		}

		return "redirect:/board/listboard";
	}

	@GetMapping("/download")
	public String download(int boardseq, HttpServletResponse response) {
		Board board = boardService.selectBoard(boardseq);

		String originalFileName = board.getOriginalfile();
		String savedFileName = board.getSavedfile();

		// Header를 세팅
		try {
			response.setHeader("Content-Disposition", 
					"attachment;filename="+URLEncoder.encode(originalFileName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String fullPath = uploadPath + "/" + savedFileName;

		// 스트림 설정(HDD입력, 클라이언트에게 출력)
		FileInputStream filein = null;
		ServletOutputStream fileout = null;

		try {
			filein = new FileInputStream(fullPath);

			fileout = response.getOutputStream();

			FileCopyUtils.copy(filein, fileout);

			fileout.close();
			filein.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 파일만 삭제
	 * @param boardseq : 삭제하려는 파일이 기록된 레코드의 시퀀스번호
	 * @return
	 */
	@GetMapping("/deleteFile")
	public String deleteFile(int boardseq, RedirectAttributes rttr) {
		Board board = boardService.selectBoard(boardseq);

		String savedFileName = board.getSavedfile();
		String fullPath = uploadPath + "/" + savedFileName;

		boolean result = FileService.deleteFile(fullPath);
		if(result) {
			boardService.updateFile(boardseq);
		}

		rttr.addAttribute("boardseq", boardseq);
		return "redirect:/board/readboard"; // 시퀀스 번호를 가져가야하는데, 어떻게 가져가지???
	}
}






















