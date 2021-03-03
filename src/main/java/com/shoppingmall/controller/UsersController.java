package com.shoppingmall.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	//모든 user 목록을 보여줌
	@GetMapping("/all")
	public List<Users> getAll(){
		return usersMapper.getAll();
	}
	
	//입력된 id와 매칭되는 user 데이터를 보여줌
	@GetMapping("/{user_sequence_id}")
	public Users getUser(@PathVariable("user_sequence_id")int user_sequence_id) {
		return usersMapper.getUsers(user_sequence_id);
	}
	
	//user 데이터 모두 입력
	@PostMapping("")
	public Users post(@RequestBody Users users) {
		usersMapper.insertUsers(users);
		return users;
	}
	
	//입력된 id와 매칭되는 user의 모든 데이터를 수정
	@PutMapping("/{user_sequence_id}")
	public void updateUser(@RequestBody Users users) {
		usersMapper.updateUsers(users);
	}
	
	//입력된 id와 매칭되는 user 데이터를 부분 수정
	@PatchMapping("/{user_sequence_id}")
	public @ResponseBody void patchUser(@PathVariable int user_sequence_id, @RequestBody Map<Object, Object> fields) {
		Users users = usersMapper.getUsers(user_sequence_id);
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(Users.class, (String)k);
			ReflectionUtils.setField(field, users, v);
		});
		usersMapper.updateUsers(users);
	}
	
	//입력된 id와 매칭되는 user 데이터를 삭제
	@DeleteMapping("/{user_sequence_id}")
	public void deleteUser(@PathVariable("user_sequence_id")int user_sequence_id) {
		usersMapper.deleteUsers(user_sequence_id);
	}
	
	//로그인 인증
//		@PostMapping("/checklogin")
//		public String checkLogin(String user_id, String user_pwd, HttpServletResponse response, HttpSession session)
//		throws Exception{
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//					
//			Users user = usersMapper.loginUser(user_id);
//
//			String status = null;
//					
//			if(user==null) {
//				status = null;
//			}else {
//				if(!user.getUser_pwd().equals(user_pwd)){
//					status = null;
//				}else {
//					session.setAttribute("id", user_id);
//					status = "success";
//				}//if else
//			}//if else
//			return status;
//		}//checkLogin()
	
	//로그인
	@PostMapping("/login")
	public String login(String user_id, String user_pwd, HttpSession session)
	throws Exception{		
		Users user = usersMapper.loginUser(user_id);

		if(user==null) {
			return "null";
		}else {
			if(!user.getUser_pwd().equals(user_pwd)){
				return "null";
			}else {
				session.setAttribute("sessionUser", user);
				return "user";
			}//if else
		}//if else
	}//login()
	
	//로그아웃
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("sessionUser");
	}
	
}
