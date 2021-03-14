package com.shoppingmall.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.shoppingmall.model.KakaoPayApprovalVO;
import com.shoppingmall.model.KakaoPayReadyVO;
import com.shoppingmall.model.KakaoPayVO;

import lombok.extern.java.Log;

@Service
@Log
public class KakaoPay {
	
	private static final String HOST = "https://kapi.kakao.com";
	
	private KakaoPayReadyVO kakaoPayReadyVO;
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	private KakaoPayVO kakaoPayVO;

	public String kakaoPayReady(KakaoPayVO Kakaopayvo) {
		
		RestTemplate restTemplate = new RestTemplate();	
		
		//서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+"kakao admin key");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		//서버로 요청할 Body		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", Kakaopayvo.getPartner_order_id());
        params.add("partner_user_id", Kakaopayvo.getPartner_user_id());
        params.add("item_name", Kakaopayvo.getItem_name());
        params.add("quantity", Integer.toString(Kakaopayvo.getQuantity()));
        params.add("total_amount", Integer.toString(Kakaopayvo.getTotal()));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:5000/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:5000/kakaoPayCancel");
        params.add("fail_url", "http://localhost:5000/kakaoPaySuccessFail");
        
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params,headers);
         
        try {
        	kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
        	
        	log.info(""+kakaoPayReadyVO);
        	
        	return kakaoPayReadyVO.getNext_redirect_pc_url();
        }catch(RestClientException e) {
        	e.printStackTrace();
        }catch(URISyntaxException e) {
        	e.printStackTrace();
        }
        
        return null;
	}
	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token, KakaoPayVO Kakaopayvo) {
		 
        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");
        
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "26c15c896ee565d71c3319b4c1a1472b");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", kakaoPayVO.getPartner_order_id());
        params.add("partner_user_id", kakaoPayVO.getPartner_user_id());
        params.add("pg_token", pg_token);
        params.add("total_amount", Integer.toString(kakaoPayVO.getTotal()));
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("" + kakaoPayApprovalVO);
          
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    }

}
