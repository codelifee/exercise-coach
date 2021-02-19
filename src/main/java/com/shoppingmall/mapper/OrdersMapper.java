package com.shoppingmall.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Orders;

@Mapper
public interface OrdersMapper {
	
	@Select("select u.user_address, u.user_id, o.*, p.product_name, p.product_price from orders o "+ 
			"join products p on o.product_id=p.product_id " + 
			"join users u on o.user_sequence_id=u.user_sequence_id")
	List<Orders> findAll();
	
	@Select("select u.user_address, u.user_id, o.*, p.product_name, p.product_price from orders o " + 
			"join products p on o.product_id=p.product_id "+
			"join users u on o.user_sequence_id=u.user_sequence_id where o.order_id=#{order_id}")
	Orders getOrders(@Param("order_id")int order_id);

	@Insert("insert into orders (user_sequence_id, order_date_created, order_status, order_amount) "
			+ "values(#{orders.user_sequence_id}, now(),#{orders.order_status},#{orders.order_amount})")
	@Options(useGeneratedKeys = true, keyProperty = "order_id")
	int insert(@Param("orders") Orders orders);
	
	@Update("update orders set user_sequence_id=#{orders.user_sequence_id}, "
			+ "order_status=#{orders.order_status},order_amount=#{orders.order_amount} where order_id=#{orders.order_id}")
	int updateOrders(@Param("orders") Orders orders);
	
	@Update("update orders set order_status=#{orders.order_status} where order_id=#{orders.order_id}")
	int updateStatus(@Param("orders") Orders orders);
	
	@Delete("delete from orders where order_id=#{order_id}")
	int deleteOrders(@Param("order_id")int order_id);

	@Select("select p.product_picture from orders o join products p on o.product_id=p.product_id " + 
			"where o.order_id=#{order_id}")
	@Options(useGeneratedKeys = true, keyProperty = "order_id")
	byte[] selectImage(int order_id);

	@Select("select u.user_address, u.user_id, o.*, p.product_name, p.product_price from orders o " + 
			"join products p on o.product_id=p.product_id "+
			"join users u on o.user_sequence_id=u.user_sequence_id where u.user_sequence_id=#{user_sequence_id}")
	List<Orders> getOrdersByUserId(int user_sequence_id);


	
	
}
