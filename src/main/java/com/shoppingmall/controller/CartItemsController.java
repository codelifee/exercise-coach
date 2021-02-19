package com.shoppingmall.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

import com.shoppingmall.mapper.CartItemsMapper;
import com.shoppingmall.model.CartItems;

@RestController
@RequestMapping("/cartitems")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartItemsController {

	@Autowired
	private CartItemsMapper cartItemsMapper;
	
	@GetMapping("/all")
	public List<CartItems> getAll(){
		return cartItemsMapper.getAll();
	}

	@GetMapping("/{cart_item_id}")
	public CartItems getCartItems(@PathVariable("cart_item_id") int cart_item_id) {
		return cartItemsMapper.getCartItems(cart_item_id);
	}
	
	@GetMapping("/getCartItemsByUser/{user_sequence_id}")
	public CartItems getCartItemsByUser(@PathVariable("user_sequence_id") int user_sequence_id) {
		return cartItemsMapper.getCartItemsByUser(user_sequence_id);
	}

	@PostMapping("")
	public CartItems post(@RequestBody CartItems cartitems) {
		cartItemsMapper.insert(cartitems);
		return cartitems;
	}
	
	@PutMapping("/{cart_item_id}")
	public void updateCartItems(@PathVariable("cart_item_id") int cart_item_id,@RequestBody CartItems cartitems) {
		cartItemsMapper.updateCartItems(cartitems);
	}
	
	@PatchMapping("/{cart_item_id}")
	public @ResponseBody void patchCartItem(@PathVariable int cart_item_id, @RequestBody Map<Object, Object> fields) {
		CartItems cartitems = cartItemsMapper.getCartItems(cart_item_id);	
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(CartItems.class, (String)k);
			ReflectionUtils.setField(field, cartitems, v);
		});
		cartItemsMapper.updateCartItems(cartitems);
	}
	
	@DeleteMapping("/{cart_item_id}")
	public void deleteUser(@PathVariable("cart_item_id")int cart_item_id) {
		cartItemsMapper.deleteCartItems(cart_item_id);
	}

}
