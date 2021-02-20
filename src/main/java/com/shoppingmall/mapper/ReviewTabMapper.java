package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.ReviewTab;

@Mapper
public interface ReviewTabMapper {

	@Select("select r.*, u.user_id from review_tab r join users u on r.user_sequence_id=u.user_sequence_id order by r.review_id asc")
	List<ReviewTab> getAll();

	@Select("select r.*, u.user_id from review_tab r join users u on r.user_sequence_id=u.user_sequence_id where r.review_id=#{review_id}")
	   ReviewTab getReviewTab(@Param("review_id")int review_id);
	
	@Select("select review_id, product_id, user_sequence_id, review, star, review_date_created from review_tab order by review_id")
	List<ReviewTab> getAllJsonData();
	
	@Select("select review_id, product_id, user_sequence_id, review, star, review_date_created from review_tab where review_id=#{review_id} order by review_id")
	ReviewTab getJsonData(@Param("review_id")int review_id);
	
	@Insert("INSERT INTO review_tab(product_id,user_sequence_id, review, star, review_picture"
			+ "review_date_created) VALUES(#{reviewTab.product_id}, #{reviewTab.user_sequence_id},"
			+ "#{reviewTab.review},#{reviewTab.star}, #{reviewTab.review_picture}, now())")
	@Options(useGeneratedKeys = true, keyProperty = "review_id")
	int insertReviewTabs(@Param("reviewTab") ReviewTab reviewTab);
	
	@Insert("INSERT INTO review_tab(product_id,user_sequence_id, review, star, "
			+ "review_date_created) VALUES(#{reviewTab.product_id}, #{reviewTab.user_sequence_id},"
			+ "#{reviewTab.review},#{reviewTab.star}, now())")
	@Options(useGeneratedKeys = true, keyProperty = "review_id")
	int insertReviewTab(@Param("reviewTab") ReviewTab reviewTab);
	
	@Update("UPDATE review_tab SET product_id=#{reviewTab.product_id}, user_sequence_id=#{reviewTab.user_sequence_id}, "
			+ "review=#{reviewTab.review}, star=#{reviewTab.star}, "
			+ "review_picture=#{reviewTab.review_picture} WHERE review_id=#{reviewTab.review_id}")
	int updateReviewTab(@Param("reviewTab") ReviewTab reviewTab);
	
	@Update("UPDATE review_tab SET review_picture=#{review_picture} WHERE review_id=#{review_id}")
	int UpdateReviewPicture(@Param("review_picture")byte[] review_picture, @Param("review_id")int review_id);

	@Delete("DELETE FROM review_tab WHERE review_id=#{review_id}")
	int deleteReviewTab(@Param("review_id")int review_id);

}
