package net.kdigital.test3.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Guestbook {
	private int seq;
	private String usrname;
	private String usrpwd;
	private String text;
	private String regdate;
}
