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
	
	@Select("select product_id, category_id, product_name, product_description, product_price, stock from products order by product_id")
	List<Products> getAllJsonData();
	
	@Select("select product_id, category_id, product_name, product_description, product_price, stock from products where product_id=#{product_id} order by product_id ")
	Products getJsonData(@Param("product_id") int product_id);	


	@Select("select p.product_name, p.product_id, p.product_description, p.product_price, p.stock, c.category_name from products as p join categories as c on p.category_id=c.category_id where c.category_id=#{category_id} order by product_id")
	List<Products> getCategoryProducts(@Param("category_id") int category_id);
	
	@Insert("INSERT INTO products(category_id,product_name,product_description,product_price, stock)"
	      + " VALUES(#{products.category_id}, #{products.product_name},#{products.product_description},"
	      + "#{products.product_price}, #{products.stock})")
	@Options(useGeneratedKeys = true, keyProperty = "product_id")
	int insertProduct(@Param("products") Products products);
	   
	@Insert("INSERT INTO products(category_id,product_name,product_description,product_price, stock,"
	      + "product_picture, info_img, quality_img)"
	      + " VALUES(#{products.category_id}, #{products.product_name},#{products.product_description}, "
	      + "#{products.product_price}, #{products.stock}, #{products.product_picture}, #{products.info_img}, #{products.quality_img})")
	@Options(useGeneratedKeys = true, keyProperty = "product_id")
	int insertProducts(@Param("products") Products products);

	@Update("UPDATE products SET category_id=#{products.category_id},product_name=#{products.product_name},product_description=#{products.product_description},"
			+ "product_price=#{products.product_price}, stock=#{products.stock} "
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
	


	
	@Select("select p.product_name, p.product_id, p.product_description, p.product_price, p.stock, p.category_id from products as p where p.product_name LIKE CONCAT('%',#{search},'%')")
	List<Products> showSearchResult(@Param("search")String search);

	


}
