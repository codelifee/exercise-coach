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

import com.shoppingmall.mapper.CartItemsMapper;
import com.shoppingmall.model.CartItems;

@RestController
@RequestMapping("/cartitems")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartItemsController {

	@Autowired
	private CartItemsMapper cartItemsMapper;
	
//	@Autowired
//	private CartItemsService cartItemsService;
	
	@GetMapping("/all")
	public List<CartItems> getAll(){
		return cartItemsMapper.getAll();
	}
	

	@GetMapping("/{cart_item_id}")
	public CartItems getCartItems(@PathVariable("cart_item_id") int cart_item_id) {
		return cartItemsMapper.getCartItems(cart_item_id);
	}
	

	@PostMapping("")
	public CartItems post(@RequestBody CartItems cartitems) {
		cartItemsMapper.insert(cartitems);
		return cartitems;
	}
	
	
	@PutMapping("/{cart_item_id}")
	public void updateCartItems(@PathVariable("cart_item_id") int cart_item_id,
			@RequestParam("cart_item_quantity") int cart_item_quantity) {
		cartItemsMapper.updateCartItems(cart_item_id, cart_item_quantity);
		
	}
	
	@DeleteMapping("/{cart_item_id}")
	public void deleteUser(@PathVariable("cart_item_id")int cart_item_id) {
		cartItemsMapper.deleteCartItems(cart_item_id);
	}
	
}
