package com.shoppingmall.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppingmall.model.Users;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	com.shoppingmall.mapper.UsersMapper usersMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Users> user = usersMapper.findByUserName(userName);
		
		System.out.print(user);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not fount: " + userName));
		
		return user.map(MyUserDetails::new).get();
	}

}
