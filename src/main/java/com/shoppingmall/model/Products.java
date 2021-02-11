package com.shoppingmall.model;

public class Products {
	
	private int product_id;	
	private int category_id;
	private String product_name;
	private String product_description;
	private int product_price;
	private byte[] product_picture;
	private int stock;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	
}
