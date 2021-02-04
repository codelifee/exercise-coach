package com.shoppingmall.model;

public class CartItems {
	
	private int cart_item_id;
	private int user_sequence_id;
	private int product_detail_id;
	private int product_id; 
	private int cart_item_quantity;
	private String product_color;
	private int product_stock;
	
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
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
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

	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

}
