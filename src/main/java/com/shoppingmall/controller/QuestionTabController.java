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

import com.shoppingmall.mapper.QuestionTabMapper;
import com.shoppingmall.model.QuestionTab;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionTabController {
	
	@Autowired
	private QuestionTabMapper questionTabMapper;
	
	@GetMapping("/all")
	public List<QuestionTab> getAll(){
		return questionTabMapper.getAll();
	}	
	
	@GetMapping("/{question_id}")
	public QuestionTab get(@PathVariable("question_id")int question_id) {
		return questionTabMapper.getQuestionTab(question_id);
	}
	
	@PostMapping("")
	public QuestionTab insert(@RequestBody QuestionTab questionTab) {
		questionTabMapper.insertQuestionTab(questionTab);
		return questionTab;
	}
	
	@PutMapping("/{question_id}")
	public void update(@RequestBody QuestionTab questionTab) {
		questionTabMapper.updateQuestionTab(questionTab);
		}
	
	@PatchMapping("/{question_id}")
	public @ResponseBody void patchQuestion(@PathVariable int question_id, @RequestBody Map<Object, Object> fields) {
		QuestionTab questionTab = questionTabMapper.getQuestionTab(question_id);
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(QuestionTab.class, (String)k);
			ReflectionUtils.setField(field, questionTab, v);
		});
		questionTabMapper.updateQuestionTab(questionTab);
	}
	
	@DeleteMapping("/{question_id}")
	public void delete(@PathVariable("question_id")int question_id){
		questionTabMapper.deleteQuestionTab(question_id);
	}

}
