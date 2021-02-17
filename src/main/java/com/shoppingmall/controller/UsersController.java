package com.shoppingmall.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.UsersMapper;
import com.shoppingmall.model.Users;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return usersMapper.getAll();
	}
	
	@GetMapping("/{user_sequence_id}")
	public Users getUser(@PathVariable("user_sequence_id")int user_sequence_id) {
		return usersMapper.getUsers(user_sequence_id);
	}
	
	@PostMapping("")
	public Users post(@RequestBody Users users) {
		usersMapper.insertUsers(users);
		return users;
	}
	
	@PutMapping("/{user_sequence_id}")
	public void updateUser(@PathVariable("user_sequence_id")int user_sequence_id,
			@Param("user_pwd")String user_pwd, @Param("user_name")String user_name,
			@Param("user_phone")String user_phone, @Param("user_address")String user_address) {
		usersMapper.updateUsers(user_pwd, user_name, user_phone, user_address, user_sequence_id);
	}
	
	@DeleteMapping("/{user_sequence_id}")
	public void deleteUser(@PathVariable("user_sequence_id")int user_sequence_id) {
		usersMapper.deleteUsers(user_sequence_id);
	}
}
