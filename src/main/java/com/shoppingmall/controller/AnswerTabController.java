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

import com.shoppingmall.mapper.AnswerTabMapper;
import com.shoppingmall.model.AnswerTab;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnswerTabController {
	
	@Autowired
	private AnswerTabMapper answerMapper;
	
	@GetMapping("/all")
	public List<AnswerTab> getAll(){
		return answerMapper.getAll();
	}
	
	@GetMapping("/{answer_id}")
	public AnswerTab get(@PathVariable("answer_id")int answer_id) {
		return answerMapper.getAnswerTab(answer_id);
	}
	
	@PostMapping("")
	public AnswerTab insert(@RequestBody AnswerTab answerTab) {
		answerMapper.insertAnswerTab(answerTab);
		return answerTab;
	}
	
	@PutMapping("/{answer_id}")
	public void update(@PathVariable("answer_id")int answer_id, @Param("question_id") int question_id, @Param("answer") String answer) {
		answerMapper.updatequestionTab(answer_id, question_id, answer);
		}
	
	@DeleteMapping("/{answer_id}")
	public void delete(@PathVariable("answer_id")int answer_id){
		answerMapper.deleteAnswerTab(answer_id);
	}

}
