//package com.shoppingmall.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shoppingmall.mapper.AnswerTabMapper;
//import com.shoppingmall.mapper.QuestionTabMapper;
//import com.shoppingmall.model.QuestionTab;
//
//@Service
//public class QuestionTabService {
//
//	@Autowired
//	private QuestionTabMapper questionTabMapper;
//	
//	@Autowired
//	private AnswerTabMapper answerTabMapper;
//	
//	public List<QuestionTab> getAll(){
//		List<QuestionTab> questionTabList = questionTabMapper.getAll();
//		if(questionTabList != null & questionTabList.size() > 0) {
//			for(QuestionTab questionTab : questionTabList) {
//				questionTab.setAnswerTabList(answerTabMapper.getByQuestionId(questionTab.getQuestion_id()));
//			}//for
//		}//if
//		return questionTabList;
//	}//getAll()
//	
//}
