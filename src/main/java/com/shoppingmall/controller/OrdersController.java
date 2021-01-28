package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.OrdersMapper;
import com.shoppingmall.model.Orders;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins="http://localhost:5000")
public class OrdersController {
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@GetMapping("/all")
	public List<Orders> getAll(){
		return ordersMapper.findAll();
	}
	
	@GetMapping("/{order_id}")
	public Orders getUser(@PathVariable("order_id")int order_id) {
		return ordersMapper.getOrders(order_id);
	}
	
	@PostMapping("")
	public Orders post(@RequestBody Orders orders) {
		ordersMapper.insert(orders);
		return  orders;
	}
	
	@PutMapping("/{order_id}")
	public void updateOrder(@PathVariable("order_id")int order_id, @RequestParam("user_sequence_id")int user_sequence_id,
			@RequestParam("order_date_created")String order_date_created,
			@RequestParam("order_status")String order_status, 
			@RequestParam("order_amount")int order_amount) {
		ordersMapper.updateOrders(user_sequence_id, order_date_created, order_status, order_amount);
	}
	
	@DeleteMapping("/{order_id}")
	public void deleteOrder(@PathVariable("order_id")int order_id) {
		ordersMapper.deleteOrders(order_id);
	}

}
