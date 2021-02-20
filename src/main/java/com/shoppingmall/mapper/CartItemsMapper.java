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
import com.shoppingmall.model.Products;

@Mapper
public interface CartItemsMapper {

	@Select("select c.*, p.product_name, p.product_price, p.product_picture "
			+ "from cart_items c join products p on c.product_id = p.product_id order by c.cart_item_id")
	List<CartItems> getAll();
	
	@Select("select c.*, p.product_name, p.product_price, p.product_picture "
			+ "from cart_items c join products p on c.product_id = p.product_id WHERE c.cart_item_id=#{cart_item_id}")
	CartItems getCartItems(@Param("cart_item_id")int cart_item_id);
	
	@Select("select c.*, p.product_name, p.product_price, p.product_picture "
			+ "from cart_items c join products p on c.product_id = p.product_id WHERE c.user_sequence_id=#{user_sequence_id}")
	CartItems getCartItemsByUser(@Param("user_sequence_id")int user_sequence_id);	
	
	@Select("select * from products p where p.product_id in (select c.product_id from cart_items c where c.cart_item_id=#{cart_item_id})") 
	Products getProductImage(@Param("cart_item_id")int cart_item_id);
	
	@Insert("INSERT INTO cart_items(user_sequence_id, product_id, cart_item_quantity)"
			+ " VALUES(#{cartitems.user_sequence_id}, #{cartitems.product_id}, #{cartitems.cart_item_quantity})")
	@Options(useGeneratedKeys=true, keyProperty = "cart_item_id")
	int insert(@Param("cartitems")CartItems cartitems);
	
	@Update("UPDATE cart_items SET user_sequence_id=#{cartitems.user_sequence_id}, product_id=#{cartitems.product_id}, "
			+ "cart_item_quantity=#{cartitems.cart_item_quantity} where cart_item_id=#{cartitems.cart_item_id}")
	void updateCartItems(@Param("cartitems") CartItems cartitems);
	
	@Delete("DELETE FROM cart_items WHERE cart_item_id=#{cart_item_id}")
	int deleteCartItems(@Param("cart_item_id")int cart_item_id);


}
