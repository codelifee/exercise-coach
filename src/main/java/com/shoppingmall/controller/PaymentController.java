package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.PaymentMapper;
import com.shoppingmall.model.Payment;


@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	//모든 답변 목록을 보여줌
	@GetMapping("/all")
	public List<Payment> getAll(){
		return paymentMapper.getAll();
	}
	
	//입력된 id와 매칭되는 답변 데이터 보여줌 
	@GetMapping("/{merchant_uid}")
	public Payment get(@PathVariable("merchant_uid")String merchant_uid) {
		return paymentMapper.getPayment(merchant_uid);
	}
	
	//답변 데이터 모두 입력
	@PostMapping("")
	public Payment insert(@RequestBody Payment payment) {
		paymentMapper.insertPayment(payment);
		return payment;
	}
	
	//입력된 id와 매칭되는 답변 데이터 삭제
	@DeleteMapping("/{merchant_uid}")
	public void delete(@PathVariable("merchant_uid")String merchant_uid){
		paymentMapper.deletePayment(merchant_uid);
	}

}
