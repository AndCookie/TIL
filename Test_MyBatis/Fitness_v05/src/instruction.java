/*
 * 1) 프로젝트 생성
 * 2) 디팬던시 추가 : Build Path
 * 
 * 3) 패키지 생성
 * 	  : 통상적으로 url을 뒤집어서 패키지를 3~4단계로 만듦
 * 		ex) www.naver.com이라는 url을 뒤집어서 com.naver.news.vo로 생성
 * 		 -> net.kdigital.fitness.vo
 * 		 -> net.kdigital.fitness.service
 * 		 -> net.kdigital.fitness.main
 * 		 -> net.kdigital.fitness.ui
 * 		 -> net.kdigital.fitness.dao : 여기에 ConnectionManager 넣기
 * 
 * 4) 예전에 작성한 코드를 하나씩 복사 후 오류 처리하기
 * 
 * 5) fitness 테이블 생성하기
 * 	  : src에서 우클릭 > new > File > src에 파일명 fitness.sql로 생성 > 해당 보관용 파일에 sql문 복붙해두기
 *  
 * 6) dao 패키지 안에 인터페이스를 설계
 * 	  : 데이터베이스와 연동하는 클래스 파일을 작성
 * 
 * 7) 기존에 ServiceImpl이 하던 일을 DAOImpl로 넘기기
 * 
 * 8) DAOImpl 만들기
 * 	  : 참고로 자동 commit되므로 insert into문이나 delete문 쓴 후에 commit 생략해도 됨
 * 
 * 
 */
public class instruction {

}
