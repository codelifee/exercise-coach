package com.shoppingmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shoppingmall.model.QuestionTab;

@Mapper
public interface QuestionTabMapper {


	@Select("select * from question_tab")
	@Results(id="QuestionTabMap", value= {
			@Result(property = "product_picture", column = "product_id", many=@Many(select="com.shoppingmall.mapper.ProductsMapper.getProductPicture")),	
			@Result(property ="answerTabList", column="question_id", many=@Many(select="com.shoppingmall.mapper.AnswerTabMapper.getanswerTab"))
		})
	List<QuestionTab> getAll();
	
	@Select("select * from question_tab where question_id=#{question_id}")
	@ResultMap("QuestionTabMap")
	QuestionTab getQuestionTab(@Param("question_id")int question_id);
	
	@Insert("INSERT INTO question_tab(product_id,user_sequence_id,question,question_date_created) "
			+ "VALUES(#{questionTab.product_id},#{questionTab.user_sequence_id},#{questionTab.question},now())")
	@Options(useGeneratedKeys = true, keyProperty = "question_id")
	int insertQuestionTab(@Param("questionTab") QuestionTab questionTab);
	
	@Update("UPDATE question_tab SET product_id=#{product_id},user_sequence_id=#{user_sequence_id},"
			+ "question=#{question} WHERE question_id=#{question_id}")
	int updateQuestionTab(@Param("question_id") int question_id,
			@Param("product_id") int product_id,@Param("user_sequence_id") int user_sequence_id,
			@Param("question") String question);
	
	@Delete("DELETE FROM question_tab WHERE question_id=#{question_id}")
	int deleteQuestionTab(@Param("question_id")int question_id);

	
}
