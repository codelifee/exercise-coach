package com.shoppingmall.controller;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.CartItemsMapper;
import com.shoppingmall.model.CartItems;

@RestController
@RequestMapping("/rest/cartitems")
@CrossOrigin(origins="http://localhost:5000")
public class CartItemsController {

	
	private CartItemsMapper cartItemsMapper;
	
	@Autowired
	public CartItemsController(CartItemsMapper cartItemsMapper) {
		this.cartItemsMapper = cartItemsMapper;
	}
	
	@GetMapping("/{cart_item_id}")
	public CartItems getCartItems(@PathVariable("cart_item_id") int cart_item_id) {
		return cartItemsMapper.getCartItems(cart_item_id);
	}
	
	@GetMapping("")
	public List<CartItems> getAll(){
		return cartItemsMapper.findAll();
	}
	
	
	@PostMapping("")
	public CartItems post(@RequestBody CartItems cartitems) {
		cartItemsMapper.insert(cartitems);
		return cartitems;
	}
	
	
	@PutMapping("/{cart_item_id}")
	public void putCartItems(@PathVariable("cart_item_id") int cart_item_id, @RequestParam("user_sequence_id") int user_sequence_id,
			@RequestParam("product_detail_id") int product_detail_id, @RequestParam("product_id") int product_id, 
			@RequestParam("cart_item_quantity") int cart_item_quantity) {
		
	}
}
