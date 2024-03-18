package net.kdigital.spring7.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageNavigator {
	// 멤버
	private int pagePerGroup; 	  // 1. 그룹 당 페이지 수
	private int countPerPage; 	  // 2. 페이지 당 글 개수
	private int totalRecordCount; // 3. 전체 글 개수
	private int totalPageCount;   // 4. 전체 페이지 개수 ===
	private int totalGroupCount;  // 5. 전체 그룹 개수
	private int currentPage ; 	  // 6. 사용자가 요청한 현재 페이지
	private int currentGroup; 	  // 7. 사용자가 요청한 페이지가 속한 그룹
	private int startPageGroup;   // 8. 현재 그룹의 첫 페이지
	private int endPageGroup;     // 9. 현재 그룹의 끝 페이지
	private int startRecord;      // 10. 사용자가 요청한 페이지의 첫 글 번호
	private int endRecord;	      // 11. 사용자가 요청한 페이지의 끝 글 번호
	
	public PageNavigator(int countPerPage, int pagePerGroup, int currentPage, int totalRecordCount) {
		// 초기화 1/2/3/6번
		this.pagePerGroup = pagePerGroup;
		this.countPerPage = countPerPage;
		this.totalRecordCount = totalRecordCount;
		this.currentPage = currentPage;
		
		// 전체 페이지 개수 계산 (4번)
		totalPageCount = totalRecordCount / countPerPage;
		totalPageCount += (totalRecordCount % countPerPage == 0) ? 0 : 1;
		
		// 사용자가 요청한 페이지의 첫/끝 글 번호 계산 (10, 11번)
		startRecord = countPerPage * (currentPage-1) + 1; // 10 * 1 + 1 = 11
		endRecord 	= countPerPage * (currentPage-1) + countPerPage; // 10 * 1 + 10 = 20
		
		// 전체 그룹수
		totalGroupCount = totalPageCount / pagePerGroup;
		totalGroupCount += (totalPageCount % countPerPage == 0) ? 0 : 1;
		
		// 사용자가 요청한 페이지가 속한 그룹 계산 (7번)
		currentGroup = (currentPage-1) / pagePerGroup;

		// 현재 그룹의 첫/끝 페이지 (8, 9번)
		startPageGroup = currentGroup * pagePerGroup + 1; // 6
		startPageGroup = (startPageGroup < 1) ? 1 : startPageGroup;
		endPageGroup = (currentGroup+1) * pagePerGroup; // 10
		endPageGroup = (endPageGroup > totalPageCount) ? totalPageCount : endPageGroup;
	}
	
}
