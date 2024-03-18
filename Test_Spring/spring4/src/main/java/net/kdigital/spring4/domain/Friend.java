package net.kdigital.spring4.domain;

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
	private String name;
	private int age;
	private String phone;
	private boolean active;
	// isActive도 getter임!!
}
