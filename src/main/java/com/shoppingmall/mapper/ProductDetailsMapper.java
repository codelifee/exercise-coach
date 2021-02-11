package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.ProductDetails;

@Mapper
public interface ProductDetailsMapper {

	@Select("select * from product_details")
	List<ProductDetails> getAll();

	@Select("select * from product_details where product_detail_id=#{product_detail_id}")
	ProductDetails getProductDetails(@Param("product_detail_id")int product_detail_id);
	
	@Insert("INSERT INTO product_details(product_id,product_color, product_size, info_image, quality_image)"
			+ "VALUES(#{productDetails.product_id},#{productDetails.product_color},#{productDetails.product_size},"
			+ "#{productDetails.info_image}, #{productDetails.quality_image})")
	@Options(useGeneratedKeys = true, keyProperty = "product_detail_id")
	int insertProductDetails(@Param("productDetails") ProductDetails productDetails);
	
	@Update("UPDATE product_details SET product_id=#{product_id},product_color=#{product_color},"
			+ " product_size=#{product_size}, info_image=#{info_image}, quality_image=#{quality_image} "
			+ "WHERE product_detail_id=#{product_detail_id}")
	int updateProductDetails(@Param("product_detail_id") int product_detail_id,@Param("product_id") int product_id,
			@Param("product_color") String product_color, @Param("product_size") String product_size,
			@Param("info_image") byte[] info_image, @Param("quality_image") byte[] quality_image);
	
	@Delete("DELETE FROM product_details WHERE product_detail_id=#{product_detail_id}")
	int deleteProductDetails(@Param("product_detail_id")int product_detail_id);

}




