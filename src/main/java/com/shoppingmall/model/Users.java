package com.shoppingmall.model;

public class Users {

	private int user_sequence_id;
	private String user_id;
	private String user_pwd;
	private String user_pwd2;
	private String user_name;
	private String user_phone;
	private String user_address;
	private String user_date_joined;
	
	public int getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(int user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_date_joined() {
		return user_date_joined;
	}
	public void setUser_date_joined(String user_date_joined) {
		this.user_date_joined = user_date_joined;
	}
	public String getUser_pwd2() {
		return user_pwd2;
	}
	public void setUser_pwd2(String user_pwd2) {
		this.user_pwd2 = user_pwd2;
	}
}
