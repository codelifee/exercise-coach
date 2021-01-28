package com.shoppingmall.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.Users;

@Mapper
public interface UsersMapper {
	
	@Select("select * from users order by user_sequence_id")
	List<Users> findAll();
	
	@Select("select * from users where user_sequence_id=#{user_sequence_id}")


	Users getUsers(@Param("user_sequence_id")int user_sequence_id);


	@Insert("insert into users (user_id,user_pwd,user_name, user_date_of_birth, user_email, user_phone, user_address,"
			+ "user_date_joined) values(#{users.user_id},#{users.user_pwd},#{users.user_name},#{users.user_date_of_birth},"
			+ "#{users.user_email},#{users.user_phone},#{users.user_address},now())")
	@Options(useGeneratedKeys = true, keyProperty = "user_sequence_id")
	int insertUsers(@Param("users") Users users);

	
	@Update("update users set user_pwd=#{user_pwd}, user_name=#{user_name}, user_date_of_birth=#{user_date_of_birth},"
			+ "user_email=#{user_email}, user_phone=#{user_phone}, user_address=#{user_address}"
			+ "where user_sequence_id=#{user_sequence_id}")

	int updateUsers(@Param("user_pwd")String user_pwd, @Param("user_name")String user_name,


			@Param("user_date_of_birth")String user_date_of_birth, @Param("user_email")String user_email,
			@Param("user_phone")String user_phone, @Param("user_address")String user_address, 
			@Param("user_sequence_id")int user_sequence_id);
	
	@Delete("delete from users where user_sequence_id=#{user_sequence_id}")

	int deleteUsers(@Param("user_sequence_id")int user_sequence_id);
	
	@Select("select user_id from users where user_sequence_id=#{user_sequence_id}")
	@Options(useGeneratedKeys = true, keyProperty = "user_sequence_id")
	String getUserId(int user_sequence_id);
	
	@Select("select user_address from users where user_sequence_id=#{user_sequence_id}")
	@Options(useGeneratedKeys = true, keyProperty = "user_sequence_id")
	String getUserAddress(int user_sequence_id);

}
