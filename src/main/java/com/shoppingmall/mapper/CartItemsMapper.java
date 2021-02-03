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

	@Select("select * from cart_items c join product_details p on c.product_detail_id = p.product_detail_id order by cart_item_id")
	List<CartItems> getAll();
	
	@Select("select * from cart_items c join product_details p on c.product_detail_id = p.product_detail_id WHERE cart_item_id=#{cart_item_id}")
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
