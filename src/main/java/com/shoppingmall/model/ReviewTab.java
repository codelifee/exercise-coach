package com.shoppingmall.model;

import java.util.List;

public class ReviewTab {

	private int review_id;
	private int product_id;
	private int user_sequence_id;
	private int product_detail_id;
	private String review;
	private float star;
	private String review_picture;
	private String review_date_created;
	private String product_name;
	private List<ProductDetails> productDetailsList;
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
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
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public String getReview_picture() {
		return review_picture;
	}
	public void setReview_picture(String review_picture) {
		this.review_picture = review_picture;
	}
	public String getReview_date_created() {
		return review_date_created;
	}
	public void setReview_date_created(String review_date_created) {
		this.review_date_created = review_date_created;
	}
	public List<ProductDetails> getProductDetailsList() {
		return productDetailsList;
	}
	public void setProductDetailsList(List<ProductDetails> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
