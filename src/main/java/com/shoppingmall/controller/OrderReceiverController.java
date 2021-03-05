package com.shoppingmall.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.OrderReceiverMapper;
import com.shoppingmall.model.OrderReceiver;
import com.shoppingmall.model.Orders;


@RestController
@RequestMapping("/orderReceiver")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderReceiverController {
	
	@Autowired
	private OrderReceiverMapper orderReceiverMapper;
	
	
	//모든 주문내역 목록을 보여줌
	@GetMapping("/all")
	public List<OrderReceiver> getAll() {
		return orderReceiverMapper.getAll();
	}
		
	//입력된 id와 매칭되는 주문내역 데이터 보여줌
	@GetMapping("/{id}")
	public OrderReceiver getOrderReceiver(@PathVariable("id") int id) {
		return orderReceiverMapper.getOrderReceiver(id);
	}
	
	//입력된 id와 매칭되는 주문내역 데이터 보여줌
//	@GetMapping("/users/{user_sequence_id}")
//	public OrderReceiver getOrderReceiverByUser(@PathVariable("user_sequence_id") int user_sequence_id) {
//		return orderReceiverMapper.getOrderReceiverByUser(user_sequence_id);
//	}
	
	//입력된 id와 매칭되는 주문내역 데이터 보여줌
		@GetMapping("/usersall/{user_sequence_id}")
		public List<OrderReceiver> getOrderReceiverByUser(@PathVariable("user_sequence_id") int user_sequence_id) {
			return orderReceiverMapper.getOrderReceiverByUser(user_sequence_id);
		}
	
	

	//주문내역 데이터 모두 입력
	@PostMapping("")
	public OrderReceiver post(@RequestBody OrderReceiver orderReceiver) {
		orderReceiverMapper.insertOrderReceiver(orderReceiver);
		return orderReceiver;
	}

	//입력된 id와 매칭되는 주문내역 데이터 모두 수정
	@PutMapping("/{id}")
	public void updateOrderReceiver(@RequestBody OrderReceiver orderReceiver) {
		orderReceiverMapper.updateOrderReceiver(orderReceiver);
	}

	//입력된 id와 매칭되는 주문내역 데이터 부분 수정
	@PatchMapping("/{id}")
	   public @ResponseBody void patchOrderReceiver(@PathVariable int id, @RequestBody Map<Object, Object> fields) {
		OrderReceiver orderReceiver = orderReceiverMapper.getOrderReceiver(id);   
	      fields.forEach((k,v) -> {
	         Field field = ReflectionUtils.findRequiredField(OrderReceiver.class, (String)k);
	         ReflectionUtils.setField(field, orderReceiver, v);
	      });
	      orderReceiverMapper.updateOrderReceiver(orderReceiver);
	   }

	//입력된 id와 매칭되는 주문내역 데이터 삭제
	@DeleteMapping("/{id}")
	public void deleteOrderReceiver(@PathVariable("id") int id) {
		orderReceiverMapper.deleteOrderReceiver(id);
	}

}



