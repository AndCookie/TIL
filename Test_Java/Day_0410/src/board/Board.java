package board;

// VO (Value Object) : 값을 저장하기 위한 용도
public class Board {
	// 변수는 무조건 private으로 만든다고 생각하고 시작하기
	private int boardseq;
	private String title;
	private String writer;
	private String regdate;
	private String contents;
	private String attachment;
	private int viewcount;
	
	// SETTER : 정보에 데이터를 넣는 메소드
	// method는 기능을 수행 후 반환을 해야하는데,
	// void : 반환타입이 없는 키워드로 메소드에서만 사용됨
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq; // i는 지역변수
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	
	// GETTER : 데이터를 꺼내는 메소드
	// method는 기능을 수행 후 반환을 해야하는데,
	// int, double, string, array의 형태로 반환한다는 의미
	// 하나의 메소드는 오로지 한 개의 값만 리턴 가능
	public int getBoardseq() {
		return this.boardseq; // 여기서 boardseq는 멤버변수 
	}
	public String getTitle(){
		return this.title;
	}
	public String getWriter(){
		return this.writer;
	}
	public String getRegdate(){
		return this.regdate;
	}
	public String getContents(){
		return this.contents;
	}
	public String getAttachment(){
		return this.attachment;
	}
	public int getViewcount() {
		return this.viewcount;
	}
	
	// output
	public void output() { // static은 우리 멤버가 될 수 없으므로 삭제해야	
		System.out.println("번호 : " + boardseq);
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + regdate);
		System.out.println("글내용 : " + contents);
		System.out.println("첨부파일 : " + attachment);
		System.out.println("조회수 : " + viewcount);
	}

}
