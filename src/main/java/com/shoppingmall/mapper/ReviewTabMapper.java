package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.model.ReviewTab;

@Mapper
public interface ReviewTabMapper {


	@Select("select r.*, u.user_id from review_tab r join users u on r.user_sequence_id=u.user_sequence_id order by review_id asc")
	List<ReviewTab> getAll();

	@Select("select r.*, u.user_id from review_tab r join users u on r.user_sequence_id=u.user_sequence_id where review_id=#{review_id}")
	   ReviewTab getReviewTab(@Param("review_id")int review_id);
	
	@Insert("INSERT INTO review_tab(product_id,user_sequence_id, review, star, review_picture,"
			+ "review_date_created) VALUES(#{reviewTab.product_id}, #{reviewTab.user_sequence_id},"
			+ "#{reviewTab.review},#{reviewTab.star},"
			+ "#{reviewTab.review_picture},now())")
	@Options(useGeneratedKeys = true, keyProperty = "review_id")
	int insertReviewTab(@Param("reviewTab") ReviewTab reviewTab);
	
	@Update("UPDATE review_tab SET product_id=#{product_id}, user_sequence_id=#{user_sequence_id}, "
			+ "review=#{review}, star=#{star}, "
			+ "review_picture=#{imageData} WHERE review_id=#{review_id}")
	int updateReviewTab(@Param("product_id") int product_id,@Param("user_sequence_id") int user_sequence_id,
		    @Param("review") String review,
			@Param("star") float star,@Param("imageData") byte[] imageData,
			@Param("review_id") int review_id);

	
	@Delete("DELETE FROM review_tab WHERE review_id=#{review_id}")
	int deleteReviewTab(@Param("review_id")int review_id);
}
