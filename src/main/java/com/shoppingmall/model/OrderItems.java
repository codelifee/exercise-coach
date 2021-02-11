package com.shoppingmall.model;

public class OrderItems {
	
	private int order_item_id;
	private int order_id;
	private int order_item_quantity;
	private int product_id;
	private String product_name;
	private String product_description;
	private int product_price;
	private byte[] product_picture;
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public byte[] getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(byte[] product_picture) {
		this.product_picture = product_picture;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_item_quantity() {
		return order_item_quantity;
	}
	public void setOrder_item_quantity(int order_item_quantity) {
		this.order_item_quantity = order_item_quantity;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}



}
