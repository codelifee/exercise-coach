package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.CartItems;

@Mapper
public interface CartItemsMapper {

	@Select("select * from cart_items order by cart_item_id")
	@Result(property ="productDetailsList", column="product_detail_id", many=@Many(select="com.shoppingmall.mapper.ProductDetailsMapper.getAllProductDetails"))
	List<CartItems> getAll();
	
	@Select("SELECT * FROM cart_items WHERE cart_item_id=#{cart_item_id}")
	@Result(property ="productDetailsList", column="product_detail_id", many=@Many(select="com.shoppingmall.mapper.ProductDetailsMapper.getAllProductDetails"))
	CartItems getCartItems(@Param("cart_item_id")int cart_item_id);
	
	@Insert("INSERT INTO cart_items(user_sequence_id, product_detail_id, product_id, cart_item_quantity)"
			+ " VALUES(#{cartitems.user_sequence_id},#{cartitems.product_detail_id}, #{cartitems.product_id}, #{cartitems.cart_item_quantity})")
	@Options(useGeneratedKeys=true, keyProperty = "cart_item_id")
	int insert(@Param("cartitems")CartItems cartitems);
		
	
	@Update("UPDATE cart_items SET cart_item_quantity=#{cart_item_quantity} where cart_item_id=#{cart_item_id}")
	int updateCartItems(@Param("cart_item_id")int cart_item_id, 
			@Param("cart_item_quantity")int cart_item_quantity);
	
	@Delete("DELETE FROM cart_items WHERE cart_item_id=#{cart_item_id}")
	int deleteCartItems(@Param("cart_item_id")int cart_item_id);

}
