package net.kdigital.spring3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 전달인자가 없는 생성자
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
	private String userid;
	private String userpwd;
	private String username;
	private String gender;
}
