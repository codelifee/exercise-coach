package com.shoppingmall.model;

public class QuestionTab {
	
	 private int question_id;
	 private int product_id;
	 private int user_sequence_id;
	 private String question; 
	 private String question_date_created;
	 private int answer_id;
	 private String answer;
	 private String answer_date_created;
	 private int category_id;
	 private String user_id;	
	 private String product_name;
	 
	 
	 
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(int user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion_date_created() {
		return question_date_created;
	}
	public void setQuestion_date_created(String question_date_created) {
		this.question_date_created = question_date_created;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


}
