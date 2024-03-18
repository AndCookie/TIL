package net.kdigital.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardseq;
	private String memberid;
	private String title;
	private String boardtext;
	private String regdate;
	private int hitcount;
	private String originalfile;
	private String savedfile; 
}
