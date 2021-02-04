package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.DetailQualityTab;

public interface DetailQualityTabMapper {
	
	@Select("select * from detail_quality_tab order by detail_quality_id")
	List<DetailQualityTab> getAll();
	
	@Select("select * from detail_quality_tab where detail_quality_id=#{detail_quality_id}")
	DetailQualityTab getDetailQualityTab(@Param("detail_quality_id")int detail_quality_id);

	@Insert("insert into detail_quality_tab  (product_detail_id, detail_quality_picture) "
			+ "values(#{detailqualitytab.product_detail_id}, #{detailqualitytab.detail_quality_picture})")
	@Options(useGeneratedKeys = true, keyProperty = "detail_quality_id")
	int insert(@Param("detailqualitytab") DetailQualityTab detailqualitytab);
	
	@Update("update detail_quality_tab set product_detail_id=#{product_detail_id}, detail_quality_picture=#{detail_quality_picture} ")
	int updateDetailQualityTab(@Param("product_detail_id")int product_detail_id, @Param("detail_quality_picture")String detail_quality_picture);
	
	@Delete("delete from detail_quality_tab where detail_quality_id=#{detail_quality_id}")
	int deleteDetailQualityTab(@Param("detail_quality_id")int detail_quality_id);

}