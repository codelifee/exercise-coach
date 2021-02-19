package com.shoppingmall.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void updateUser(@RequestBody Users users) {
		usersMapper.updateUsers(users);
	}
	
	@PatchMapping("/{user_sequence_id}")
	public @ResponseBody void patchUser(@PathVariable int user_sequence_id, @RequestBody Map<Object, Object> fields) {
		Users users = usersMapper.getUsers(user_sequence_id);
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(Users.class, (String)k);
			ReflectionUtils.setField(field, users, v);
		});
		usersMapper.updateUsers(users);
	}
	
	@DeleteMapping("/{user_sequence_id}")
	public void deleteUser(@PathVariable("user_sequence_id")int user_sequence_id) {
		usersMapper.deleteUsers(user_sequence_id);
	}
}
