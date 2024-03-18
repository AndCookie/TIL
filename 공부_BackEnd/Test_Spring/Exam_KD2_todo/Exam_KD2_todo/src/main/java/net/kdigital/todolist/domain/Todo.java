package net.kdigital.todolist.domain;


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
public class Todo {
	private int seqno;
	private String todoid;
	private String regdate;
	private String status;
	private String importance;
	private String categories;
	private String todo;
}
