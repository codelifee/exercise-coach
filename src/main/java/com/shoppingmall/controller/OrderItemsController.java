package com.shoppingmall.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.OrderItemsMapper;
import com.shoppingmall.model.OrderItems;

@RestController
@RequestMapping("/orderitems")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	
	@GetMapping("/all")
	public List<OrderItems> getAll(){
		return orderItemsMapper.getAll();
	}
	
	@GetMapping("/{order_item_id}")
	public  OrderItems getOrderItems(@PathVariable("order_item_id")int order_item_id) {
		return orderItemsMapper.getOrderItems(order_item_id);
	}
	
	@PostMapping("")
	public OrderItems post(@RequestBody OrderItems orderitems) {
		orderItemsMapper.insert(orderitems);
		return  orderitems;
	}
	
	@PutMapping("/{order_item_id}")
	public void updateOrderItems(@PathVariable("order_item_id")int order_item_id, @Param("order_id") int order_id,
			@Param("product_id") int product_id,
			@Param("order_item_quantity")int order_item_quantity) {
		orderItemsMapper.updateOrderItems(order_item_id, order_id, product_id, order_item_quantity);
		
	}
	
	@DeleteMapping("/{order_item_id}")
	public void deleteOrder(@PathVariable("order_item_id")int order_item_id) {
		orderItemsMapper.deleteOrderItems(order_item_id);
	}

}
