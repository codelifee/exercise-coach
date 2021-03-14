package com.shoppingmall.model;

import java.util.Date;

import lombok.Data;

public class KakaoPayApprovalVO {
    
    private String aid;
    private String tid;
    private String cid;
    //요청 고유 번호, 결제 고유 번호, 가맹점 코드
    private String partner_order_id;
    private String partner_user_id;
    //가맹점 주문번호, 가맹점 회원 id
    private String item_name;
    //상품 이름
    private int quantity;
    private int tax_free_amount;
    private int total;
    //상품 수량, 상품 비과세 금약, 상품 부가세 금액
    private Date created_at;
    private Date approved_at;
    //결제 준비 요청 시각, 결제 승인 시각
    
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPartner_order_id() {
		return partner_order_id;
	}
	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}
	public String getPartner_user_id() {
		return partner_user_id;
	}
	public void setPartner_user_id(String partner_user_id) {
		this.partner_user_id = partner_user_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTax_free_amount() {
		return tax_free_amount;
	}
	public void setTax_free_amount(int tax_free_amount) {
		this.tax_free_amount = tax_free_amount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getApproved_at() {
		return approved_at;
	}
	public void setApproved_at(Date approved_at) {
		this.approved_at = approved_at;
	}
   
}
