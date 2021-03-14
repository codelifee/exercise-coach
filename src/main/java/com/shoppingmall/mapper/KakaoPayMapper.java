package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.KakaoPayVO;

public interface KakaoPayMapper {
	
	@Select("select * from kakaopay")
	List<KakaoPayVO> getAll();
	
	@Select("select * from kakaopay where id=#{id}")
	KakaoPayVO getKakaoPay(@Param("id")int id);
	
	@Insert("INSERT INTO kakaopay(partner_order_id,partner_user_id,item_name,quantity,total) "
			+ "VALUES(#{KakaoPayVO.partner_order_id}, #{KakaoPayVO.partner_user_id}, "
			+ "#{KakaoPayVO.item_name}, #{KakaoPayVO.quantity}, #{KakaoPayVO.total})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertKakaoPay(@Param("KakaoPayVO") KakaoPayVO KakaoPayVO);
	
	@Update("UPDATE kakaopay SET partner_order_id=#{KakaoPayVO.partner_order_id}, "
			+ "partner_user_id=#{KakaoPayVO.partner_user_id}, "
			+ "item_name=#{KakaoPayVO.item_name}, quantity=#{KakaoPayVO.quantity}, "
			+ "total=#{KakaoPayVO.total} WHERE id=#{KakaoPayVO.id}")
	void updateKakaoPay(@Param("KakaoPayVO") KakaoPayVO KakaoPayVO);
	
	@Delete("DELETE FROM kakaopay WHERE id=#{id}")
	int deleteKakaoPay(@Param("id")int id);
}
