package com.shoppingmall.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shoppingmall.model.Users;

public class MyUserDetails implements UserDetails{
	
	private int user_sequence_id;
	private String user_id;
	private String user_pwd;
	private List<GrantedAuthority> roles;
	private String user_name;
	private String user_phone;
	private String user_address;
	private String user_date_joined;
	
	public MyUserDetails(Users user) {
		this.user_name = user.getUser_name();
		this.user_id = user.getUser_id();
		this.user_pwd = user.getUser_pwd();
		this.user_phone = user.getUser_phone();
		this.user_address = user.getUser_address();
		this.user_date_joined = user.getUser_date_joined();
		this.roles = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return user_pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
