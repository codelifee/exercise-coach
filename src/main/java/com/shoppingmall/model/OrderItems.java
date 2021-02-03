package com.shoppingmall.model;

public class OrderItems {
	
	private int order_item_id;
	private int order_id;
	private int product_detail_id;
	private int order_item_quantity;
	private int product_id;
	private String product_color;
	
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
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
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
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}

}
