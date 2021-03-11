package com.shoppingmall.kakaopay;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayApprovalVO {
    
    //response
    private String aid, tid, cid, sid;
    //요청 고유 번호, 결제 고유 번호, 가맹점 코드, 정기결제용ID
    private String partner_order_id, partner_user_id, payment_method_type;
    //가맹점 주문번호, 가맹점 회원 id, 결제수단(card or money)
    private AmountVO amount;
    //결제 금액
    private CardVO card_info;
    //결제 상세 정보(카드 결제 시)
    private String item_name, item_code, payload;
    //상품 이름, 상품 코드, 결제 승인 요청에 대해 저장한 값
    private Integer quantity, tax_free_amount, vat_amount;
    //상품 수량, 상품 비과세 금약, 상품 부가세 금액
    private Date created_at, approved_at;
    //결제 준비 요청 시각, 결제 승인 시각
   
}
