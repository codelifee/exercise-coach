package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.AnswerTab;

@Mapper
public interface AnswerTabMapper {

	@Select("select * from answer_tab")
	List<AnswerTab> getAll();
	
	@Select("select * from answer_tab where answer_id=#{answer_id}")
	AnswerTab getAnswerTab(@Param("answer_id")int answer_id);
	
	@Insert("INSERT INTO answer_tab(question_id,answer,answer_date_created) "
			+ "VALUES(#{answerTab.question_id},#{answerTab.answer},now())")
	@Options(useGeneratedKeys = true, keyProperty = "answer_id")
	int insertAnswerTab(@Param("answerTab") AnswerTab answerTab);
	
	@Update("UPDATE answer_tab SET question_id=#{question_id},answer=#{answer} WHERE answer_id=#{answer_id}")
	int updatequestionTab(@Param("answer_id") int answer_id,
			@Param("question_id") int question_id, @Param("answer") String answer);
	
	@Delete("DELETE FROM answer_tab WHERE answer_id=#{answer_id}")
	int deleteAnswerTab(@Param("answer_id")int answer_id);

}










