package net.kdigital.test2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Person {
	private String userid;
	private String username;
	private int year;
	private String gender;
	private int age;
}
