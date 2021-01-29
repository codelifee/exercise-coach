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

import com.shoppingmall.mapper.DetailQualityTabMapper;
import com.shoppingmall.model.DetailQualityTab;

@RestController
@RequestMapping("/detailqualitytab")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailQualityTabController {

	@Autowired
	private DetailQualityTabMapper detailqualitytabmapper;
	
	
	@GetMapping("/all")
	public List<DetailQualityTab> getAll(){
		return detailqualitytabmapper.findAll();
	}
	
	@GetMapping("/{detail_quality_id}")
	public DetailQualityTab get(@PathVariable("detail_quality_id")int detail_quality_id) {
		return detailqualitytabmapper.getDetailQualityTab(detail_quality_id);
	}
	
	@PostMapping("")
	public DetailQualityTab insert(@RequestBody DetailQualityTab detailqualitytab) {
		detailqualitytabmapper.insert(detailqualitytab);
		return detailqualitytab;
	}
	
	@PutMapping("/{detail_quality_id}")
	public void update(@PathVariable("detail_quality_id")int detail_quality_id, @Param("product_detail_id") int product_detail_id, 
			@Param("detail_quality_picture") String detail_quality_picture ) {
		detailqualitytabmapper.updateDetailQualityTab(product_detail_id, detail_quality_picture);
		}
	
	@DeleteMapping("/{detail_quality_id}")
	public void delete(@PathVariable("detail_quality_id")int detail_quality_id){
		detailqualitytabmapper.deleteDetailQualityTab(detail_quality_id);
	}
}

