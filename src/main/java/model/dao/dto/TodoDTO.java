package model.dao.dto;

import java.sql.Date;

public class TodoDTO {
	private int id;
	private String todo;
	private Date timeLimit;

	// 引数なしコンストラクタ
	public TodoDTO() {
		id =0;
		todo = "";
		timeLimit = new Date(System.currentTimeMillis());		
	}
	// 引数ありコンストラクタ
	public TodoDTO(int id, String todo, Date timeLimit) {
		this.id = id;
		this.todo = todo;
		this.timeLimit = timeLimit;
	}
	
	// getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Date timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	
	
	
}
