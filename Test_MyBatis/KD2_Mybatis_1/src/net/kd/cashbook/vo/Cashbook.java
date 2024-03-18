package net.kd.cashbook.vo;

public class Cashbook {
	private int seq;
	private String dates;
	private int itemid;
	private String detail;
	private int amount;
	private String note;
	public Cashbook() {
		super();
	}
	public Cashbook(int seq, String dates, int itemid, String detail, int amount, String note) {
		super();
		this.seq = seq;
		this.dates = dates;
		this.itemid = itemid;
		this.detail = detail;
		this.amount = amount;
		this.note = note;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		String temp = String.format("%d / %s / %s / %,d / %s  ", seq, dates, detail, amount , note);
		return temp;
	}
}
