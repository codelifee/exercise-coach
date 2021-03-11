package com.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.kakaopay.KakaoPay;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/pay")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
	private KakaoPay kakaopay;
	
	@GetMapping("/kakaoPay")
	public void kakoPayGet() {
		
	}
	
	@PostMapping("/kakaoPay")
	public String kakaoPay() {
		log.info("kakaoPay post.........................................");
		
		return "" + kakaopay.kakaoPayReady();
	}
	
	@GetMapping("/kakaoPaySuccess")
	public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("kakaoPaySuccess get..........................................");
		log.info("kakaoPaySuccess pg_token : " + pg_token);
		
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
	}
}
