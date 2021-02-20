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

import com.shoppingmall.mapper.AnswerTabMapper;
import com.shoppingmall.model.AnswerTab;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnswerTabController {
	
	@Autowired
	private AnswerTabMapper answerMapper;
	
	//모든 답변 목록을 보여줌
	@GetMapping("/all")
	public List<AnswerTab> getAll(){
		return answerMapper.getAll();
	}
	
	//입력된 id와 매칭되는 답변 데이터 보여줌 
	@GetMapping("/{answer_id}")
	public AnswerTab get(@PathVariable("answer_id")int answer_id) {
		return answerMapper.getAnswerTab(answer_id);
	}
	
	//답변 데이터 모두 입력
	@PostMapping("")
	public AnswerTab insert(@RequestBody AnswerTab answerTab) {
		answerMapper.insertAnswerTab(answerTab);
		return answerTab;
	}
	
	//입력된 id와 매칭되는 답변 데이터 모두 수정
	@PutMapping("/{answer_id}")
	public void update(@PathVariable("answer_id")int answer_id, @RequestBody AnswerTab answerTab) {
		answerMapper.updateAnswerTab(answerTab);
	}
	
	
	///입력된 id와 매칭되는 답변 데이터 부분 수정
	@PatchMapping("/{answer_id}")
	public @ResponseBody void patchAnswer(@PathVariable int answer_id, @RequestBody Map<Object, Object> fields) {
		AnswerTab answerTab = answerMapper.getAnswerTab(answer_id);	
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(AnswerTab.class, (String)k);
			ReflectionUtils.setField(field, answerTab, v);
		});
		answerMapper.updateAnswerTab(answerTab);
	}
	
	//입력된 id와 매칭되는 답변 데이터 삭제
	@DeleteMapping("/{answer_id}")
	public void delete(@PathVariable("answer_id")int answer_id){
		answerMapper.deleteAnswerTab(answer_id);
	}

}
