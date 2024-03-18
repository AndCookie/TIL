package net.kdigital.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Reply {
	private int replyseq;
	private int boardseq;
	private String memberid;
	private String replytext;
	private String regdate;
}
