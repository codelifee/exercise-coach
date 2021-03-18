package com.shoppingmall.model;

public class Payment {

	private String merchant_uid;
	private int user_sequence_id;
	private String product_name;
	private String amount;
	private String user_name;
	private String user_phone;
	private String user_id;
	private String date_of_payment;
	
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public int getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(int user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDate_of_payment() {
		return date_of_payment;
	}
	public void setDate_of_payment(String date_of_payment) {
		this.date_of_payment = date_of_payment;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
