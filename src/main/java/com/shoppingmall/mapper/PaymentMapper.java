package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shoppingmall.model.Payment;

@Mapper
public interface PaymentMapper {
	
	@Select("select * from payment")
	List<Payment> getAll();
	
	@Select("select * from payment where merchant_uid=#{merchant_uid}")
	Payment getPayment(@Param("merchant_uid")String merchant_uid);
	
	@Insert("INSERT INTO payment VALUES(#{payment.merchant_uid},#{payment.product_name}, "
			+ "#{payment.amount}, #{payment.user_name}, now())")
	int insertPayment(@Param("payment") Payment payment);

	@Delete("DELETE FROM payment WHERE merchant_uid=#{merchant_uid}")
	int deletePayment(@Param("merchant_uid")String merchant_uid);

}
