package com.shoppingmall.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.mapper.ReviewTabMapper;
import com.shoppingmall.model.ReviewTab;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewTabController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewTabController.class);

	@Autowired
	private ReviewTabMapper reviewTabMapper;
	//모든 리뷰 목록을 보여줌
	@GetMapping("/all")
	public List<ReviewTab> getAll(){
		return reviewTabMapper.getAll();
	}
	//입력된 id와 매칭되는 리뷰 데이터 보여줌
	@GetMapping("/{review_id}")
	public ReviewTab get(@PathVariable("review_id")int review_id) {
		return reviewTabMapper.getReviewTab(review_id);
	}
	
	//이미지 제외한 리뷰 전체 데이터 보여줌
	@GetMapping("/allJsonData")
	public List<ReviewTab> getAllJsonData(){
		return reviewTabMapper.getAllJsonData();
	}

	@GetMapping("/JsonData/{review_id}")
	public ReviewTab getAJsonData(@PathVariable("review_id")int review_id){
		return reviewTabMapper.getJsonData(review_id);
	}
	//입력된 id와 매칭되는 review_picture 보여줌
	@GetMapping("/showReviewImage/{review_id}")
	   @ResponseBody
	   public ResponseEntity<?> showReviewImage(@PathVariable("review_id") int review_id, HttpServletResponse response,
	         HttpServletRequest request) throws IOException, SQLException {
	      try {
	         ReviewTab r = reviewTabMapper.getReviewTab(review_id);
	         response.setContentType("image/jpeg; image/jpg; image/png; image/gif");

	         response.getOutputStream().write(r.getReview_picture());
	         response.getOutputStream().close();
	         return new ResponseEntity<>("Image Import Successful!", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         logger.info("Exception: " + e);
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	      }
	   }
	//이미지 제외한 리뷰 데이터 모두 입력
	@PostMapping("")
	public ReviewTab insert(@RequestBody ReviewTab reviewTab) {
		reviewTabMapper.insertReviewTab(reviewTab);		
		return reviewTab;
	}
	//review_pictured 및 일반필드 데이터 입력
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("product_id") int product_id,
			@RequestParam("user_sequence_id") int user_sequence_id,	@RequestParam("review") String review, @RequestParam("star") float star//@RequestParam("review_date_created") String review_date_created,
			, HttpServletRequest request, final @RequestParam("review_picture") MultipartFile review_picture) {
		
        logger.info(String.format("File name '%s' uploaded successfully.", review_picture.getOriginalFilename()));
        
        try {			
			byte[] imageData = review_picture.getBytes();
			ReviewTab r = new ReviewTab();

			r.setProduct_id(product_id);
			r.setUser_sequence_id(user_sequence_id);			
			r.setReview(review);
			r.setStar(star);
			r.setReview_picture(imageData);

			reviewTabMapper.insertReviewTabs(r);

			logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }
	//입력된 id와 매칭되는 리뷰 데이터 모두 수정
	@PutMapping("/{review_id}")
	public void update(@RequestBody ReviewTab reviewTab) {
		reviewTabMapper.updateReviewTab(reviewTab);
	}
	//입력된 id와 매칭되는 리뷰 데이터 부분 수정
	@PatchMapping("/{review_id}")
	public @ResponseBody void patchReview(@PathVariable int review_id, @RequestBody Map<Object, Object> fields) {
		ReviewTab reviewTab = reviewTabMapper.getReviewTab(review_id);	
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(ReviewTab.class, (String)k);
			ReflectionUtils.setField(field, reviewTab, v);
		});
		reviewTabMapper.updateReviewTab(reviewTab);
	}

	//입력된 id와 매칭되는 review_picture 수정
	@PatchMapping("/image/{review_id}")
	public void updateImage(@PathVariable("review_id")int review_id,
			@RequestParam("review_picture") MultipartFile review_picture) throws IOException {
		byte[] imageData= review_picture.getBytes();
		reviewTabMapper.UpdateReviewPicture(imageData, review_id);
	}
	//입력된 id와 매칭되는 리뷰 데이터 삭제
	@DeleteMapping("/{review_id}")
	public void delete(@PathVariable("review_id")int review_id){
		reviewTabMapper.deleteReviewTab(review_id);
	}

}
