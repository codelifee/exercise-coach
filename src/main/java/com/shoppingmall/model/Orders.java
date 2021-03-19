package com.shoppingmall.model;

public class Orders {
	
	private int order_id;
	private int user_sequence_id;
	private String order_date_created;
	private String order_status;
	private int order_amount;
	private String user_id;
	private String user_address;
	private String product_name;
	private int product_price;
	private int quantity;
	private int product_id;
	private String order_return;
	private byte[] product_picture;
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(int user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public String getOrder_date_created() {
		return order_date_created;
	}
	public void setOrder_date_created(String order_date_created) {
		this.order_date_created = order_date_created;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public byte[] getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(byte[] product_picture) {
		this.product_picture = product_picture;
	}
	public String getOrder_return() {
		return order_return;
	}
	public void setOrder_return(String order_return) {
		this.order_return = order_return;
	}

}
