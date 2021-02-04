package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.DetailInformationTab;
import com.shoppingmall.model.DetailQualityTab;

public interface DetailInformationTabMapper {

	
	@Select("select * from detail_information_tab order by detail_information_id")
	List<DetailInformationTab> getAll();

	
	@Select("select * from detail_information_tab where detail_information_id=#{detail_information_id}")
	DetailInformationTab getDetailInformationTab(@Param("detail_information_id")int detail_information_id);

	@Insert("insert into detail_information_tab  (product_detail_id, detail_information_picture) "
			+ "values(#{detailinformationtab.product_detail_id}, #{detailinformationtab.detail_information_picture})")
	@Options(useGeneratedKeys = true, keyProperty = "detail_information_id")
	int insert(@Param("detailinformationtab") DetailInformationTab detailinformationtab);
	
	@Update("update detail_information_tab set product_detail_id=#{product_detail_id}, detail_information_picture=#{detail_information_picture} ")
	int updateDetailInformationTab(@Param("product_detail_id")int product_detail_id, @Param("detail_information_picture")String detail_information_picture);
	
	@Delete("delete from detail_information_tab where detail_information_id=#{detail_information_id}")
	int deleteDetailInformationTab(@Param("detail_information_id")int detail_information_id);


}
