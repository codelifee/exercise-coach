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

import com.shoppingmall.mapper.QuestionTabMapper;
import com.shoppingmall.model.Administrator;
import com.shoppingmall.model.QuestionTab;
import com.shoppingmall.model.Users;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins="http://localhost:5000")
public class QuestionTabController {
	
	@Autowired
	private QuestionTabMapper questionTabMapper;

	@GetMapping("/all")
	public List<QuestionTab> getAll(){
		return questionTabMapper.getAll();
	}
	
	@GetMapping("/{question_id}")
	public Users get(@PathVariable("question_id")int question_id) {
		return questionTabMapper.getQuestionTab(question_id);
	}
	
	@PostMapping("")
	public QuestionTab insert(@RequestBody QuestionTab questionTab) {
		questionTabMapper.insertquestionTab(questionTab);
		return questionTab;
	}
	
	@PutMapping("/{question_id}")
	public void update(@PathVariable("question_id")int question_id, 
			@Param("product_id") int product_id,@Param("user_sequence_id") int user_sequence_id,
			@Param("question") String question) {
		questionTabMapper.updatequestionTab(question_id, product_id, user_sequence_id, question);
		}
	
	@DeleteMapping("/{question_id}")
	public void delete(@PathVariable("question_id")int question_id){
		questionTabMapper.deletequestionTab(question_id);
	}

}
