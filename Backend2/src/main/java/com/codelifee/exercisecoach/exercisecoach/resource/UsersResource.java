package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelifee.exercisecoach.exercisecoach.mapper.UsersMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Users;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

	private UsersMapper usersMapper;
	
	public UsersResource() {
		
	}
		
	@Autowired
	public UsersResource(UsersMapper usersMapper) {
		super();
		this.usersMapper = usersMapper;
	}

	@GetMapping("/all")
	public List<Users> getAll() {
		return usersMapper.findAll();
	}
}
