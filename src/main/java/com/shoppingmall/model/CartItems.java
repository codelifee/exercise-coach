package com.shoppingmall.model;

public class CartItems {
	
	private int cart_item_id;
	private int user_sequence_id;
	private int product_id; 
	private int cart_item_quantity;
	private String product_name;
	private byte[] product_picture;

	public int getCart_item_id() {
		return cart_item_id;
	}
	public void setCart_item_id(int cart_item_id) {
		this.cart_item_id = cart_item_id;
	}
	public int getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(int user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCart_item_quantity() {
		return cart_item_quantity;
	}
	public void setCart_item_quantity(int cart_item_quantity) {
		this.cart_item_quantity = cart_item_quantity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public byte[] getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(byte[] product_picture) {
		this.product_picture = product_picture;
	}


}
