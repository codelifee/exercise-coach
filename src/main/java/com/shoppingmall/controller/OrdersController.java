package com.shoppingmall.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
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

import com.shoppingmall.mapper.OrdersMapper;
import com.shoppingmall.model.Orders;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdersController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Autowired
	private OrdersMapper ordersMapper;

	//모든 주문내역 목록을 보여줌
	@GetMapping("/all")
	public List<Orders> getAll() {
		return ordersMapper.findAll();
	}
		
	//입력된 id와 매칭되는 주문내역 데이터 보여줌
	@GetMapping("/{order_id}")
	public Orders getUser(@PathVariable("order_id") int order_id) {
		return ordersMapper.getOrders(order_id);
	}
	
	//입력된 user_id와 매칭되는 주문내역 데이터 보여줌
	@GetMapping("/userid/{user_sequence_id}")
	public List<Orders> getUserByUserId(@PathVariable("user_sequence_id") int user_sequence_id) {
		return ordersMapper.getOrdersByUserId(user_sequence_id);
	}	

	//주문내역 데이터 모두 입력
	@PostMapping("")
	public Orders post(@RequestBody Orders orders) {
		ordersMapper.insert(orders);
		return orders;
	}

	//입력된 id와 매칭되는 주문내역 데이터 모두 수정
	@PutMapping("/{order_id}")
	public void updateOrder(@RequestBody Orders orders) {
		ordersMapper.updateOrders(orders);
	}

	//입력된 id와 매칭되는 주문내역 데이터 부분 수정
	@PatchMapping("/{order_id}")
	   public @ResponseBody void patchOrder(@PathVariable int order_id, @RequestBody Map<Object, Object> fields) {
	      Orders order = ordersMapper.getOrders(order_id);   
	      fields.forEach((k,v) -> {
	         Field field = ReflectionUtils.findRequiredField(Orders.class, (String)k);
	         ReflectionUtils.setField(field, order, v);
	      });
	      ordersMapper.updateOrders(order);
	   }

	//입력된 id와 매칭되는 주문내역 데이터 삭제
	@DeleteMapping("/{order_id}")
	public void deleteOrder(@PathVariable("order_id") int order_id) {
		ordersMapper.deleteOrders(order_id);
	}

}









