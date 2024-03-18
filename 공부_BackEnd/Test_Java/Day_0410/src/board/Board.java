package board;

// VO (Value Object) : ���� �����ϱ� ���� �뵵
public class Board {
	// ������ ������ private���� ����ٰ� �����ϰ� �����ϱ�
	private int boardseq;
	private String title;
	private String writer;
	private String regdate;
	private String contents;
	private String attachment;
	private int viewcount;
	
	// SETTER : ������ �����͸� �ִ� �޼ҵ�
	// method�� ����� ���� �� ��ȯ�� �ؾ��ϴµ�,
	// void : ��ȯŸ���� ���� Ű����� �޼ҵ忡���� ����
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq; // i�� ��������
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
	
	
	// GETTER : �����͸� ������ �޼ҵ�
	// method�� ����� ���� �� ��ȯ�� �ؾ��ϴµ�,
	// int, double, string, array�� ���·� ��ȯ�Ѵٴ� �ǹ�
	// �ϳ��� �޼ҵ�� ������ �� ���� ���� ���� ����
	public int getBoardseq() {
		return this.boardseq; // ���⼭ boardseq�� ������� 
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
	public void output() { // static�� �츮 ����� �� �� �����Ƿ� �����ؾ�	
		System.out.println("��ȣ : " + boardseq);
		System.out.println("���� : " + title);
		System.out.println("�ۼ��� : " + writer);
		System.out.println("�ۼ��� : " + regdate);
		System.out.println("�۳��� : " + contents);
		System.out.println("÷������ : " + attachment);
		System.out.println("��ȸ�� : " + viewcount);
	}

}
