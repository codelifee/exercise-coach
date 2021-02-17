package com.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.mapper.OrdersMapper;

@Service
public class OrdersService {
	
	@Autowired
	OrdersMapper ordersMapper;

	public void updateStatus(int order_id, String order_status) {
		ordersMapper.updateStatus(order_status, order_id);
	}
	
	
	
}
