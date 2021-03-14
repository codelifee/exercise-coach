package com.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.kakaopay.KakaoPay;
import com.shoppingmall.mapper.KakaoPayMapper;
import com.shoppingmall.model.KakaoPayVO;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/pay")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
	private KakaoPay kakaopay;
	
	@Autowired
	private KakaoPayMapper kakaoPayMapper;
	
	@GetMapping("/kakaoPay/{id}")
	public String kakoPayGet(@PathVariable("id")int id) {
		
		KakaoPayVO Kakaopayvo = kakaoPayMapper.getKakaoPay(id);
		
		return "" + kakaopay.kakaoPayReady(Kakaopayvo);
	}
	
	@PostMapping("/kakaoPay")
	public void kakaoPay(@RequestBody KakaoPayVO KakaoPayVO) {
		log.info("kakaoPay post.........................................");
		
		kakaoPayMapper.insertKakaoPay(KakaoPayVO);
	}
	
	@GetMapping("/kakaoPaySuccess/{id}")
	public void kakaoPaySuccess(@PathVariable("id")int id, @RequestParam("pg_token") String pg_token, Model model) {
		log.info("kakaoPaySuccess get..........................................");
		log.info("kakaoPaySuccess pg_token : " + pg_token);
		
		KakaoPayVO Kakaopayvo = kakaoPayMapper.getKakaoPay(id);
		
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token,Kakaopayvo));
	}
}
