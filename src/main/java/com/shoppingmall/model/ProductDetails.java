package com.shoppingmall.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {

	private int product_detail_id;
	private int product_id;
	private String product_color;
	private String product_size;
	private byte[] info_image;
	private byte[] quality_image;
	private List<byte[]> imageList = new ArrayList<>();
	
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
	public String getProduct_size() {
		return product_size;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public byte[] getInfo_image() {
		return info_image;
	}
	public void setInfo_image(byte[] info_image) {
		this.info_image = info_image;
	}
	public byte[] getQuality_image() {
		return quality_image;
	}
	public void setQuality_image(byte[] quality_image) {
		this.quality_image = quality_image;
	}
	public List<byte[]> getImageList() {
		return imageList;
	}
	public void setImageList(List<byte[]> imageList) {
		this.imageList = imageList;
	}
}
