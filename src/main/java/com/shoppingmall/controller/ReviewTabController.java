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

import com.shoppingmall.mapper.ReviewTabMapper;
import com.shoppingmall.model.ReviewTab;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins="http://localhost:5000")
public class ReviewTabController {

	@Autowired
	private ReviewTabMapper reviewTabMapper;

	@GetMapping("/all")
	public List<ReviewTab> getAll(){
		return reviewTabMapper.getAll();
	}
	
	@GetMapping("/{review_id}")
	public ReviewTab get(@PathVariable("review_id")int review_id) {
		return reviewTabMapper.getReviewTab(review_id);
	}
	
	@PostMapping("")
	public ReviewTab insert(@RequestBody ReviewTab reviewTab) {
		reviewTabMapper.insertReviewTab(reviewTab);
		return reviewTab;
	}
	
	@PutMapping("/{review_id}")
	public void update(@PathVariable("review_id")int review_id, @Param("product_id") int product_id,
			@Param("user_sequence_id") int user_sequence_id, @Param("product_detail_id") int product_detail_id,
			@Param("review") String review,@Param("star") float star,@Param("review_picture") String review_picture) {
		reviewTabMapper.updateReviewTab(product_id, user_sequence_id, product_detail_id, review, star, review_picture, review_id);
		}
	
	@DeleteMapping("/{review_id}")
	public void delete(@PathVariable("review_id")int review_id){
		reviewTabMapper.deleteReviewTab(review_id);
	}
}
