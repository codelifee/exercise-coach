package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.CartItems;

@Mapper
public interface CartItemsMapper {

	@Select("select * from cartitems")
	List<CartItems> findAll();
	
	@Select("SELECT * FROM cartitems WHERE cart_item_id=#{cart_item_id}")
	CartItems getCartItems(@Param("cart_item_id")int cart_item_id);
	
	@Insert("INSERT INTO cart_items(user_sequence_id, product_detail_id, product_id,cart_item_quantity)"
			+ " VALUES(#{user_sequence_id},#{product_detail_id}, #{product_id}, #{cart_item_quantity})")
	@Options(useGeneratedKeys=true, keyProperty = "cart_item_id")
	int insert(@Param("cartitems")CartItems cartitems);
		
	
	@Update("UPDATE cartitems SET exercise_name=#{exercise_name},descriptions=#{descriptions} where exercise_sequence_id=#{exercise_sequence_id}")
	int updateCartItems(@Param("exercise_sequence_id")int exercise_sequence_id, 
			@Param("exercise_name")String exercise_name, @Param("descriptions")String descriptions);
	
	@Delete("DELETE FROM cartitems WHERE exercise_sequence_id=#{exercise_sequence_id}")
	int deleteCartItems(@Param("exercise_sequence_id")int exercise_sequence_id);
}
