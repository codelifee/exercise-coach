package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.UsersMapper;
import com.shoppingmall.model.Users;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:5000")
public class UsersController {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return usersMapper.findAll();
	}
	
	@GetMapping("/{user_sequence_id}")
	public Users getUser(@PathVariable("user_sequence_id")int user_sequence_id) {
<<<<<<< HEAD
		return usersMapper.getUsers(user_sequence_id);
=======
		return usersMapper.getUser(user_sequence_id);
>>>>>>> 39aa652b9041e2a0697f4da73001d9b6948f3d89
	}
	
	@PostMapping("")
	public Users post(@RequestBody Users users) {
<<<<<<< HEAD
		usersMapper.insertUsers(users);
=======
		usersMapper.insert(users);
>>>>>>> 39aa652b9041e2a0697f4da73001d9b6948f3d89
		return users;
	}
	
	@PutMapping("/{user_sequence_id}")
	public void updateUser(@RequestParam("user_pwd")String user_pwd, @RequestParam("user_name")String user_name,
			@RequestParam("user_date_of_birth")String user_date_of_birth, @RequestParam("user_email")String user_email,
			@RequestParam("user_phone")String user_phone, @RequestParam("user_address")String user_address,
			@PathVariable("user_sequence_id")int user_sequence_id) {
<<<<<<< HEAD
		usersMapper.updateUsers(user_pwd, user_name, user_date_of_birth, user_email, user_phone, user_address, user_sequence_id);
=======
		usersMapper.updateUser(user_pwd, user_name, user_date_of_birth, user_email, user_phone, user_address, user_sequence_id);
>>>>>>> 39aa652b9041e2a0697f4da73001d9b6948f3d89
	}
	
	@DeleteMapping("/{user_sequence_id}")
	public void deleteUser(@PathVariable("user_sequence_id")int user_sequence_id) {
<<<<<<< HEAD
		usersMapper.deleteUsers(user_sequence_id);
=======
		usersMapper.deleteUser(user_sequence_id);
>>>>>>> 39aa652b9041e2a0697f4da73001d9b6948f3d89
	}

}
