package com.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.mapper.ProductsMapper;
import com.shoppingmall.model.Products;

@Service
public class ProductsService {
	@Autowired
	ProductsMapper productsMapper;

	public void updateProducts(Products products) {
		products.getProduct_picture();
		
	}
	
	
	
	
}
