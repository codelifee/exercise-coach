package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.QuestionTab;

@Mapper
public interface QuestionTabMapper {

	@Select("select q.*, u.user_id from question_tab q left outer join answer_tab a on q.question_id=a.question_id join users u on u.user_sequence_id=q.user_sequence_id  order by q.question_id")
	List<QuestionTab> getAll();
	
	@Select("select q.*, u.user_id from question_tab q left outer join answer_tab a on q.question_id=a.question_id join users u on u.user_sequence_id=q.user_sequence_id where q.question_id=#{question_id}")
	QuestionTab getQuestionTab(@Param("question_id")int question_id);
	
	@Insert("INSERT INTO question_tab(product_id,user_sequence_id,question,question_date_created) "
			+ "VALUES(#{questionTab.product_id},#{questionTab.user_sequence_id},#{questionTab.question},now())")
	@Options(useGeneratedKeys = true, keyProperty = "question_id")
	int insertQuestionTab(@Param("questionTab") QuestionTab questionTab);
	
	@Update("UPDATE question_tab SET product_id=#{questionTab.product_id},user_sequence_id=#{questionTab.user_sequence_id},"
			+ "question=#{questionTab.question} WHERE question_id=#{questionTab.question_id}")
	int updateQuestionTab(@Param("questionTab") QuestionTab questionTab);
	
	@Delete("DELETE FROM question_tab WHERE question_id=#{question_id}")
	int deleteQuestionTab(@Param("question_id")int question_id);

	
}
