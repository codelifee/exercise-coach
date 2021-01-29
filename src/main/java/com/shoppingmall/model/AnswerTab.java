package com.shoppingmall.model;

public class AnswerTab {

	private int answer_id;
	private int question_id;
	private String answer;
	private String answer_date_created;
	
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer_date_created() {
		return answer_date_created;
	}
	public void setAnswer_date_created(String answer_date_created) {
		this.answer_date_created = answer_date_created;
	}
}
