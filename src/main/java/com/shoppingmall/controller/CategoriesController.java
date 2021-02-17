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

import com.shoppingmall.mapper.CategoriesMapper;
import com.shoppingmall.model.Categories;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriesController {

	@Autowired
	private CategoriesMapper categoriesMapper;

	@GetMapping("/all")
	public List<Categories> getAll(){
		return categoriesMapper.getAll();
	}
	
	@GetMapping("/{category_id}")
	public Categories get(@PathVariable("category_id")int category_id) {
		return categoriesMapper.getCategories(category_id);
	}
		
	@PostMapping("")
	public Categories insert(@RequestBody Categories categories) {
		categoriesMapper.insertCategories(categories);
		return categories;
	}
	
	@PutMapping("/{category_id}")
	public void update(@PathVariable("category_id")int category_id, @Param("category_name") String category_name) {
		categoriesMapper.updateCategories(category_id, category_name);
		}
	
	@DeleteMapping("/{category_id}")
	public void delete(@PathVariable("category_id")int category_id){
		categoriesMapper.deleteCategories(category_id);
	}
}
