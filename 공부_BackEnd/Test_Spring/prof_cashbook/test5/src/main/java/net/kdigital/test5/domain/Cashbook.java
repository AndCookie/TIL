package net.kdigital.test5.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Cashbook {
	private int infonum;
	private String memberid;
	private String type;
	private String memo;
	private int amount;
	private String inputdate;
}
