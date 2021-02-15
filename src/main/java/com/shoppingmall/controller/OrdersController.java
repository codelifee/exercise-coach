package com.shoppingmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.OrdersMapper;
import com.shoppingmall.model.Orders;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdersController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

	
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
			@RequestParam("order_status")String order_status, 
			@RequestParam("order_amount")int order_amount) {
		ordersMapper.updateOrders(user_sequence_id, order_status, order_amount);
	}
	
	@DeleteMapping("/{order_id}")
	public void deleteOrder(@PathVariable("order_id")int order_id) {
		ordersMapper.deleteOrders(order_id);
	}


	@GetMapping("/showProductImage/{order_id}")
	@ResponseBody
	public ResponseEntity<?> downloadFile(@PathVariable("order_id") int order_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			byte[] image = ordersMapper.selectImage(order_id);
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");

			response.getOutputStream().write(image);
			response.getOutputStream().close();
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
}
	
}
