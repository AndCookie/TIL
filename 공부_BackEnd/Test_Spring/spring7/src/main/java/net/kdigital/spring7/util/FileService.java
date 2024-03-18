package net.kdigital.spring7.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


public class FileService {
	public static String saveFile(MultipartFile upload, String uploadPath) {
		
		// 파일이 첨부된 경우 : 경로 유무를 확인하고 없으면 폴더 생성해야함
		if(!upload.isEmpty()) {
			// File이라는 폴더와 파일를 관리(생성, 삭제)하는 객체 생성하기
			File path = new File(uploadPath);
			if (!path.isDirectory()) { // isDirectory : File에서 제공해주는 메서드
				path.mkdirs(); // 디렉토리 생성
 			}
		}
		
		// === 파일 자체는 DB에 저장하고, 파일명만 오라클에 저장하기 위한 프로세스 ===
		
		// 원본의 파일명 // 그림1.jpg ==> c:\\upload\\그림_aldiafioje.jpg
		String originalFileName=upload.getOriginalFilename();
		
		// 랜덤값 발생 (int를 반환하므로 마지막에 toString)
		String uuid = UUID.randomUUID().toString();
		
		// 원본 파일명에서 확장자와 파일명을 분리
		String filename;
		String ext;
		String savedFileName; // 서버에 저장될 이름, 오라클에 저장
		
		int position = originalFileName.lastIndexOf(".");
		// 확장자가 없는 경우
		if (position == -1) ext = "";
		// 확장자가 있는 경우
		else ext = "." + originalFileName.substring(position+1);
		
		filename = originalFileName.substring(0, position);
		savedFileName = filename + "_" + uuid + ext;
		
		System.out.println("파일명: " + filename); // 그림1
		System.out.println("확장자: " + ext); // .jpg
		System.out.println("하드에 저장되는 이름: " + savedFileName); // .jpj

		
		
		// 오라클에서 서버로 접근하여 : 파일명을 가져온 후
		// 서버에서 DB로 접근하여 : DB에 파일이 있는지 확인하여 갖고 옴
		
		
		
		// 파일을 하드에 저장하기
		File serverFile = null;
		serverFile = new File(uploadPath + "/" + savedFileName);
		
		try {
			upload.transferTo(serverFile);
		} catch (Exception e) {
			savedFileName = null;
			e.printStackTrace();
		}
		
		return savedFileName;
	}
	
	
	// 삭제할 경로 포함 파일명이 조합된 문자열을 파라미터 조회
	public static boolean deleteFile(String fullPath) { // 경로명uploadPath + savefilename
		
		System.out.println(fullPath);
		
		boolean result = false; // 삭제 여부를 반환할 변수
		File delFile = new File(fullPath);
		
		// 파일이 존재하는 경우 : 파일 유무를 확인하고 있으면 삭제 진행
		if(delFile.isFile()) {
			delFile.delete();
			result = true;
		}
		
		System.out.println(result);
		
		return result;
	}

}
