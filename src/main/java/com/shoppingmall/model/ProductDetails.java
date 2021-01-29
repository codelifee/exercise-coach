package com.shoppingmall.model;

public class ProductDetails {

	private int product_detail_id;
	private int product_id;
	private String product_color;
	private int product_stock;
	
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
