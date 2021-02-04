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

import com.shoppingmall.mapper.ProductsMapper;
import com.shoppingmall.model.Products;
import com.shoppingmall.model.Users;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsController {

	@Autowired
	private ProductsMapper productsMapper;

	@GetMapping("/all")
	public List<Products> getAll(){
		return productsMapper.getAll();
	}
	
	@GetMapping("/{product_id}")
	public Products get(@PathVariable("product_id")int product_id) {
		return productsMapper.getProducts(product_id);
	}
	
	@PostMapping("")
	public Products insert(@RequestBody Products products) {
		productsMapper.insertProducts(products);
		return products;
	}
	
	@PutMapping("/{product_id}")
	public void update(@PathVariable("product_id")int product_id, @Param("category_id") int category_id,
			@Param("product_name") String product_name, @Param("product_description") String product_description,
			@Param("product_price") int product_price,@Param("product_picture") String product_picture) {
		productsMapper.updateProducts(product_id, category_id, product_name, product_description, product_price, product_picture);
		}
	
	@DeleteMapping("/{product_id}")
	public void delete(@PathVariable("product_id")int product_id){
		productsMapper.deleteProducts(product_id);
	}
}
