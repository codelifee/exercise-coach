package com.shoppingmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.shoppingmall.model.OrderItems;

@Mapper
public interface OrderItemsMapper {
	
	@Select("select o.* , p.product_name, p.product_description, p.product_price, p.product_picture from order_items as o " + 
			"join products as p on o.product_id= p.product_id")
	List<OrderItems> getAll();
	

	@Select("select o.* , p.product_name, p.product_description, p.product_price, p.product_picture from order_items as o "
			+ "join products as p on o.product_id= p.product_id where o.order_item_id=#{order_item_id}")
	OrderItems getOrderItems(@Param("order_item_id")int order_item_id);

	@Insert("insert into order_items (order_id, product_detail_id,order_item_quantity) values(#{orderitems.order_id},"
			+ "#{orderitems.product_id}, #{orderitems.order_item_quantity})")
	@Options(useGeneratedKeys = true, keyProperty = "order_item_id")
	int insert(@Param("orderitems") OrderItems orderitems);
	
	@Update("update order_items set order_item_quantity=#{order_item_quantity}, order_id=#{order_id},  product_detail_id=#{product_detail_id} where order_item_id=#{order_item_id}")
	int updateOrderItems(@Param("order_item_id")int order_item_id,  @Param("order_id") int order_id, @Param("product_id")int product_id,@Param("order_item_quantity")int order_item_quantity);
	
	@Delete("delete from order_items where order_item_id=#{order_item_id}")
	int deleteOrderItems(@Param("order_item_id")int order_item_id);
	
}
