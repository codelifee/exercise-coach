package com.shoppingmall.mapper;

import java.util.List;

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
	
	
	@Select("select * from orders order by order_id")
	List<Orders> findAll();
	
	@Select("select * from orders where order_id=#{order_id}")
	Orders getOrders(@Param("order_id")int order_id);

	@Insert("insert into orders (user_sequence_id, order_date_created, order_status, order_amount) "
			+ "values(#{orders.user_sequence_id}, now(),#{orders.order_status},#{orders.order_amount})")
	@Options(useGeneratedKeys = true, keyProperty = "order_id")
	int insert(@Param("orders") Orders orders);
	
	@Update("update orders set user_sequence_id=#{user_sequence_id}, order_date_created=#{order_date_created}, "
			+ "order_status=#{order_status},"
			+ "order_amount=#{order_amount}")
	int updateOrders(@Param("user_sequence_id")int user_sequence_id, @Param("order_date_created")String order_date_created,
			@Param("order_status")String order_status, @Param("order_amount")int order_amount);
	
	@Delete("delete from orders where order_id=#{order_id}")
	int deleteOrders(@Param("order_id")int order_id);
	

}
