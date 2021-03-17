package com.shoppingmall.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
import com.shoppingmall.model.Categories;
import com.shoppingmall.model.QuestionTab;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionTabController {

	@Autowired
	private QuestionTabMapper questionTabMapper;

	// 모든 상품 목록 전부보여줌
	@GetMapping("/all")
	public List<QuestionTab> getAll() {
		return questionTabMapper.getAll();
	}

	// 입력된 user_sequence_id와 매칭되는 데이터 가져오기
	@GetMapping("/userid/{user_sequence_id}")
	public QuestionTab getByUserId(@PathVariable("user_sequence_id") int user_sequence_id) {
		return questionTabMapper.getQuestionTabByUserId(user_sequence_id);
	}

	// 입력된 question_id와 매칭되는 데이터 가져오기
	@GetMapping("/{question_id}")
	public QuestionTab get(@PathVariable("question_id") int question_id) {
		return questionTabMapper.getQuestionTab(question_id);
	}

	
	@GetMapping("/countByProductId/{product_id}")
	public int getCountByProductId(@PathVariable("product_id") int product_id) {
		return questionTabMapper.getCountByProductId(product_id);
	}
	
	// 모든 데이터 입력
	@PostMapping("")
	public QuestionTab insert(@RequestBody QuestionTab questionTab) {
		questionTabMapper.insertQuestionTab(questionTab);
		return questionTab;
	}

	// 모든 데이터 수정
	@PutMapping("/{question_id}")
	public void update(@RequestBody QuestionTab questionTab) {
		questionTabMapper.updateQuestionTab(questionTab);
	}

	// 데이터 부분 수정
	@PatchMapping("/{question_id}")
	public @ResponseBody void patchQuestion(@PathVariable int question_id, @RequestBody Map<Object, Object> fields) {
		QuestionTab qt = questionTabMapper.getQuestionTab(question_id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findRequiredField(QuestionTab.class, (String) k);
			ReflectionUtils.setField(field, qt, v);
		});
		questionTabMapper.updateQuestionTab(qt);
	}

	// 입력된id 와 매칭되는 데이터 삭제
	@DeleteMapping("/{question_id}")
	public void delete(@PathVariable("question_id") int question_id) {
		questionTabMapper.deleteQuestionTab(question_id);
	}

}
