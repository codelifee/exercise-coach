package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Categories;
import com.shoppingmall.model.Users;

public interface CategoriesMapper {

	@Select("select * from Categories")
	List<Categories> getAll();
	
	@Select("select * from categories where category_id=#{category_id}")
	Users getCategories(@Param("category_id")int category_id);
	
	@Insert("INSERT INTO categories (category_name) VALUES(#{categories.category_name}")
	@Options(useGeneratedKeys = true, keyProperty = "category_id")
	int insertCategories(@Param("categories") Categories categories);
	
	@Update("UPDATE categories SET category_name=#{category_name}")
	int updateCategories(@Param("category_id") int category_id,
			@Param("category_name") String category_name);
	
	@Delete("DELETE FROM categories WHERE category_id=#{category_id}")
	int deleteCategories(@Param("category_id")int category_id);
}
