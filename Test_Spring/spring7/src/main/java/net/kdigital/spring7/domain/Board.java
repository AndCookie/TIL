package net.kdigital.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	// Data는 allargsconstructor를 제외한 모든 것을 만들어준다
	// 그래서 allargsconstructor를 만들면 또 data에서는 noargsconstructor을 못만든다
	// 따라서 noargsconstructor도 만들기..ㅎㅎ
	private int boardseq;
	private String memberid;
	private String title;
	private String boardtext;
	private String regdate;
	private int hitcount;
	private String originalfile;
    private String savedfile;
}
