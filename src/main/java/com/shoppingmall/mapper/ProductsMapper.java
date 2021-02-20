package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Products;

@Mapper
public interface ProductsMapper {

	@Select("select * from products order by product_id")
	List<Products> getAll();
	
	@Select("select * from products where product_id=#{product_id}")
	Products getProducts(@Param("product_id") int product_id);
	
	@Select("select product_id, category_id, product_name, product_description, product_price, stock, status from products order by product_id")
	List<Products> getAllJsonData();
	
	@Select("select product_id, category_id, product_name, product_description, product_price, stock, status from products where product_id=#{product_id} order by product_id ")
	Products getJsonData(@Param("product_id") int product_id);
	
	@Insert("INSERT INTO products(category_id,product_name,product_description,product_price, stock)"
	      + " VALUES(#{products.category_id}, #{products.product_name},#{products.product_description},"
	      + "#{products.product_price}, #{products.stock})")
	@Options(useGeneratedKeys = true, keyProperty = "product_id")
	int insertProduct(@Param("products") Products products);
	   
	@Insert("INSERT INTO products(category_id,product_name,product_description,product_price, stock, "
	      + "product_picture, info_img, quality_img)"
	      + " VALUES(#{products.category_id}, #{products.product_name},#{products.product_description}, "
	      + "#{products.product_price}, #{products.stock}, #{products.product_picture}, #{products.info_img}, #{products.quality_img})")
	@Options(useGeneratedKeys = true, keyProperty = "product_id")
	int insertProducts(@Param("products") Products products);

	@Update("UPDATE products SET category_id=#{products.category_id},product_name=#{products.product_name},product_description=#{products.product_description},"
			+ "product_price=#{products.product_price}, stock=#{products.stock}, status=#{products.status} "
			+ "WHERE product_id=#{products.product_id}")
	void updateProducts(@Param("products") Products products);
	
	@Update("update products set product_picture=#{imageData}")
	void updateProductPicture(@Param("product_id") int product_id, @Param("imageData") byte[] imageData);

	@Update("update products set info_img=#{imageData}")
	void updateInfoImg(int product_id, byte[] imageData);

	@Update("update products set quality_img=#{imageData}")
	void updateQualityImg(int product_id, byte[] imageData);
	
	@Delete("DELETE FROM products WHERE product_id=#{product_id}")
	int deleteProducts(@Param("product_id")int product_id);

}

