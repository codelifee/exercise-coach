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

import com.shoppingmall.mapper.ProductDetailsMapper;
import com.shoppingmall.model.ProductDetails;
import com.shoppingmall.model.Users;

@RestController
@RequestMapping("/productsDetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsMapper productDetailsMapper;

	@GetMapping("/all")
	public List<ProductDetails> getAll(){
		return productDetailsMapper.getAll();
	}
	
	@GetMapping("/{product_detail_id}")
	public ProductDetails get(@PathVariable("product_detail_id")int product_detail_id) {
		return productDetailsMapper.getProductDetails(product_detail_id);
	}
	
	@PostMapping("")
	public ProductDetails insert(@RequestBody ProductDetails productDetails) {
		productDetailsMapper.insertProductDetails(productDetails);
		return productDetails;
	}
	
	@PutMapping("/{product_detail_id}")
	public void update(@PathVariable("product_detail_id")int product_detail_id, @Param("product_id") int product_id,
			@Param("product_color") String product_color,@Param("product_stock") int product_stock,@Param("product_stock") String product_size) {
		productDetailsMapper.updateProductDetails(product_detail_id,product_id, product_color, product_stock,product_size);
		}
	
	@DeleteMapping("/{product_detail_id}")
	public void delete(@PathVariable("product_detail_id")int product_detail_id){
		productDetailsMapper.deleteProductDetails(product_detail_id);
	}
}
