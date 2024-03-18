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

	// application.properties 중 10과 5를 가져오기 위한 것
	@Value("${user.board.page}")
	int countPerPage;
	@Value("${user.board.group}")
	int pagePerGroup;
	
	// application.properties 중 c:/upload를 가져오기 위한 것
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
	public String listboard(@RequestParam(value="searchItem", defaultValue="title") String searchItem, 
							@RequestParam(value="searchWord", defaultValue="") String searchWord,
							@RequestParam(value="currentPage", defaultValue="1") int currentPage,
							Model model) {
		
		log.info("searchItem: {}", searchItem);
		log.info("searchWord: {}", searchWord);
		log.info("currentPage: {}", currentPage);
		
		// 데이터 베이스에서 전체 목록을 긁어오는 역할
		int totalRecordCount = boardService.getBoardCount(searchItem, searchWord);// 전체 글 개수
		log.info("글 개수 : {}", totalRecordCount);
		
		// PageNavigator 객체 생성
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordCount);
		
		
		List<Board> listboard = boardService.selectBoardAll(navi.getStartRecord(), navi.getEndRecord(),
															searchItem, searchWord);
		log.info("글 목록: {}", listboard);
		

		model.addAttribute("totalRecordCount", totalRecordCount);
		model.addAttribute("listboard", listboard);
		model.addAttribute("navi", navi);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchWord", searchWord);
		
		return "/board/listboard";
	}
	
	
	/**
	 * 글 쓰는 화면 요청
	 * @param model
	 * @return
	 */
	@GetMapping("/writeboard")
	public String writeboard() {
		return "/board/writeboard";
	}
	
	
	/**
	 * 게시글 DB 등록 요청
	 * 그림1.jpg ==> indexof(.) & substring ==> 그림1 & jpg
	 * @param board
	 * @return
	 */
	@PostMapping("/writeboard")
	public String writeboard(Board board, MultipartFile upload, Model model) {
		
		log.info("게시글: {}", board.toString());
		log.info("첨부파일: (용량){}, (파일명){}", upload.getSize(), upload.getOriginalFilename());
		log.info("서버의 업로드 경로: {}", uploadPath);
		
		String originalfile = null;
		String savedFileName = null;
		
		if (!upload.isEmpty()) {
			originalfile= upload.getOriginalFilename();
			savedFileName = FileService.saveFile(upload, uploadPath); // FileService.java의 saveFile 함수를 호출
		}

		board.setOriginalfile(originalfile);
		board.setSavedfile(savedFileName);
				
		int result = boardService.insertBoard(board); // 데이터 입력
		// 리다이렉트 : 브라우저로 하여금 요청하도록 하는 것이므로 board/를 꼭 붙여줘야 함!
		return "redirect:/board/listboard";
	}
	
	
	/**
	 * 글 1개 조회
	 * @param boardseq : 조회하려는 글의 PK
	 * @return model
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
	 * @param boardseq : 삭제하려는 글의 PK
	 * @return
	 */
	@GetMapping("/deleteboard")
	public String deleteboard(int boardseq) {
		// boardseq에 해당하는 1개의 글을 DB에서 조회
		log.info("조회글 번호: {}", boardseq);
		
		// 삭제하려는 레코드를 먼저 읽어오기
		Board board = boardService.selectBoard(boardseq);
		
		String savedFile = board.getSavedfile();
		log.info("{}", savedFile);
		
		if (savedFile !=null) {
			String fullPath = uploadPath + "/" + savedFile;
			FileService.deleteFile(fullPath);
		}
		
		int result = boardService.deleteBoard(boardseq);
		
		return "redirect:/board/listboard";
	}
	
	
	/**
	 * 글 수정 화면 요청 : 조회를 먼저 수행 후 => 수정!
	 * @param boardseq : 수정하려는 글의 PK
	 * @return
	 */
	@GetMapping("/updateboard")
	public String updateboard(int boardseq, Model model) {
		// boardseq에 해당하는 1개의 글을 DB에서 조회
		Board board = boardService.selectBoard(boardseq);
		model.addAttribute("board", board);
		
		return "/board/updateboard";
	}
	
	
	/**
	 * 글 수정 처리 요청
	 * @param board : 수정하려는 데이터
	 * @return
	 */
	@PostMapping("/updateboard")
	// 데이터 처리를 위해 DB까지 건드리는 쪽은 post
	public String updateboard(Board board, MultipartFile upload) {
		log.info("수정데이터: {}", board.toString());
		
		
		// 삭제하려는 레코드를 먼저 읽어오기
		Board oldBoard = null;
		String oldSavedfile = null; // 기존의 파일명
		String newSavedfile = null;	// 새롭게 첨부된 파일명
		
		// 기존 파일이 있고, 업로드할 파일이 있다면
		// 기존 파일을 읽어서 HDD에 저장된 파일명을 보관(oldSavedfile)) 후 삭제한 다음
		// 새 파일을 저장하기
		if (upload != null && !upload.isEmpty()) {
			oldBoard = boardService.selectBoard(board.getBoardseq()); // DB로부터 저장된
			oldSavedfile = (oldBoard == null) ? null : oldBoard.getSavedfile(); // 기존에 저장한 파일명			
			
			// 새로운 파일 저장, DB에 수정할 준비 완료
			newSavedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(newSavedfile);
			board.setOriginalfile(upload.getOriginalFilename());
		}		
		log.info("수정하는 데이터 : {}", board.toString());
		int result = boardService.updateBoard(board); // DB에 저장된 레코드 데이터를 수정함
		
		
		// 업데이트를 잘 하고, 업로드된 파일이 있다면 기존 파일 삭제
		if (result ==1 && newSavedfile != null) {
			FileService.deleteFile(uploadPath + "/" + oldSavedfile);
		}
		
		return "redirect:/board/listboard";
	}
	
	@GetMapping("/download")
	public String download(int boardseq, HttpServletResponse response){
		// new Cookie로 만든 것을 클라이언트 측에 저장할 때 사용
		
		// 다운로드하려는 레코드를 먼저 읽어오기
		Board board = boardService.selectBoard(boardseq);
		
		String originalFileName = board.getOriginalfile();
		String savedFileName = board.getSavedfile();
		
		// Header 정보를 셋팅
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(originalFileName, "UTF-8"));
					// originalFileName 내에 한글이 섞여있으면 다운로드 불가능하므로 인코딩 필수
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// DB의 파일을 SERVER로 읽어들여온 후 HTML로 보냄 
		String fullPath = uploadPath + "/" + savedFileName;
		// 스트림 설정 : (HDD하드디스크에서 입력 & 클라이언트에게 출력)
		FileInputStream filein = null;
		ServletOutputStream fileout = null;
		
		try {
			filein = new FileInputStream(fullPath); // 입력 준비 완료
			fileout = response.getOutputStream(); // 출력 준비 완료
			
			FileCopyUtils.copy(filein, fileout); // 입력-출력 서로 복사
			
			fileout.close(); // 가장 늦게 오픈한 것을 가장 빨리 닫는다
			filein.close(); // 가장 빨리 오픈한 것을 가장 늦게 닫는다
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null; // 따로 페이지 반환할 것 없음
	}
	
	
	/**
	 * 파일만 삭제
	 * @param boardseq : 삭제하려는 파일이 기록된 레코드의 시퀀스번호
	 * @return
	 */
	@GetMapping("/deletefile")
	public String deletefile(int boardseq, RedirectAttributes rttr) {
		// 기존에 저장되어있던 파일의 savedFileName 가져오기
		Board board = boardService.selectBoard(boardseq);
		String savedFileName = board.getSavedfile();
		String fullPath = uploadPath + "/" + savedFileName;
		boolean result = FileService.deleteFile(fullPath);
		
		if (result) {
			boardService.updateFile(boardseq);
		}
		rttr.addAttribute("boardseq", boardseq);
		
		return "redirect:/board/readboard";
	}
}
