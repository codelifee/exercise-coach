package com.shoppingmall.model;

public class ReviewTab {

	private int review_id;
	private int product_id;
	private int user_sequence_id;
	private String review;
	private float star;
	private byte[] review_picture;
	private String review_date_created;
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
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
	public byte[] getReview_picture() {
		return review_picture;
	}
	public void setReview_picture(byte[] review_picture) {
		this.review_picture = review_picture;
	}
	public String getReview_date_created() {
		return review_date_created;
	}
	public void setReview_date_created(String review_date_created) {
		this.review_date_created = review_date_created;
	}




	
}
