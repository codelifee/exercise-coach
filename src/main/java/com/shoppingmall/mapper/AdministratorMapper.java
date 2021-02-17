package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Administrator;

@Mapper
public interface AdministratorMapper {
	
	@Select("select * from administrator")
	List<Administrator> getAll();
	
	@Insert("INSERT INTO administrator VALUES(#{administrator.administrator_id}, #{administrator.administrator_pwd}, "
			+ "#{administrator.administrator_name})")
	int insertAdministrator(@Param("administrator") Administrator administrator);
	
	
	@Delete("DELETE FROM administrator WHERE administrator_id=#{administrator_id}")
	int deleteAdministrator(@Param("administrator_id")String administrator_id);
	
	
	@Update("UPDATE administrator SET administrator_pwd=#{administrator_pwd},administrator_name=#{administrator_name} "
			+ "WHERE administrator_id=#{administrator_id}")
	void updateAdministrator(@Param("administrator") Administrator administrator);
}
