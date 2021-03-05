package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Categories;
import com.shoppingmall.model.OrderReceiver;

@Mapper
public interface OrderReceiverMapper {

	@Select("select * from order_receiver")
	List<OrderReceiver> getAll();
	
	@Select("select * from order_receiver where id=#{id}")
	OrderReceiver getOrderReceiver(@Param("id")int id);
	
	@Select("select * from order_receiver where user_sequence_id=#{user_sequence_id}")
	List<OrderReceiver> getOrderReceiverByUser(@Param("user_sequence_id")int user_sequence_id);
	
	@Insert("INSERT INTO order_receiver (user_sequence_id, name, address, phone) VALUES(#{orderReceiver.user_sequence_id},#{orderReceiver.name},#{orderReceiver.address}, #{orderReceiver.phone})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertOrderReceiver(@Param("orderReceiver") OrderReceiver orderReceiver);
	
	@Update("UPDATE order_receiver SET name=#{orderReceiver.name}, address=#{orderReceiver.address}, phone=#{orderReceiver.phone} where user_sequence_id=#{orderReceiver.user_sequence_id}")
	void updateOrderReceiver(@Param("orderReceiver") OrderReceiver orderReceiver);
	
	@Delete("DELETE FROM order_receiver WHERE id=#{id}")
	int deleteOrderReceiver(@Param("id")int id);
}
