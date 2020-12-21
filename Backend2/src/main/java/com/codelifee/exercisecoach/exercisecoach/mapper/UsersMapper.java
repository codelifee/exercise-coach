package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.codelifee.exercisecoach.exercisecoach.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	List<Users> findAll();
	
}
