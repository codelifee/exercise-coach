package com.shoppingmall.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.shoppingmall.mapper.OrdersMapper;
import com.shoppingmall.model.Orders;
import com.shoppingmall.model.Products;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdersController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);


	@Autowired
	private OrdersMapper ordersMapper;

	@GetMapping("/all")
	public List<Orders> getAll() {
		return ordersMapper.findAll();
	}
		
	@GetMapping("/{order_id}")
	public Orders getUser(@PathVariable("order_id") int order_id) {
		return ordersMapper.getOrders(order_id);
	}
	
	@GetMapping("/userid/{user_sequence_id}")
	public List<Orders> getUserByUserId(@PathVariable("user_sequence_id") int user_sequence_id) {
		return ordersMapper.getOrdersByUserId(user_sequence_id);
	}

	@PostMapping("")
	public Orders post(@RequestBody Orders orders) {
		ordersMapper.insert(orders);
		return orders;
	}

	@PutMapping("/{order_id}")
	public void updateOrder(@RequestBody Orders orders) {
		ordersMapper.updateOrders(orders);
	}

	@PatchMapping("/{order_id}")
	   public @ResponseBody void patchOrder(@PathVariable int order_id, @RequestBody Map<Object, Object> fields) {
	      Orders order = ordersMapper.getOrders(order_id);   
	      fields.forEach((k,v) -> {
	         Field field = ReflectionUtils.findRequiredField(Orders.class, (String)k);
	         ReflectionUtils.setField(field, order, v);
	      });
	      ordersMapper.updateOrders(order);
	   }

	
	@DeleteMapping("/{order_id}")
	public void deleteOrder(@PathVariable("order_id") int order_id) {
		ordersMapper.deleteOrders(order_id);
	}


	@GetMapping("/showProductImage/{order_id}")
	@ResponseBody
	public ResponseEntity<?> showProductImage(@PathVariable("order_id") int order_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			Products p = ordersMapper.selectProducts(order_id); 
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");

			response.getOutputStream().write(p.getProduct_picture());
			response.getOutputStream().close();
			return new ResponseEntity<>("Image Import Successful!" , HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}









