package net.kdigital.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//롬복의 도움을 받아 쉽게 만들 수 있다
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Friend {
	private String fname; // table(friend.sql) 생성시 fname으로 만들었으므로 name -> fname으로 맞춰서 변경해주기
	private int age;
	private String phone;
	private boolean active;
	// isActive도 getter임!!
}
