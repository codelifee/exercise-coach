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

import com.shoppingmall.mapper.DetailInformationTabMapper;
import com.shoppingmall.model.DetailInformationTab;
import com.shoppingmall.model.DetailQualityTab;

@RestController
@RequestMapping("/detailinformationtab")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailInformationTabController {

	@Autowired
	private DetailInformationTabMapper detailinformationmapper;
	
	
	@GetMapping("/all")
	public List<DetailInformationTab> getAll(){
		return detailinformationmapper.getAll();
	}
	
	@GetMapping("/{detail_information_id}")
	public DetailInformationTab get(@PathVariable("detail_information_id")int detail_information_id) {
		return detailinformationmapper.getDetailInformationTab(detail_information_id);
	}
	
	@PostMapping("")
	public DetailInformationTab insert(@RequestBody DetailInformationTab detailinformationtab) {
		detailinformationmapper.insert(detailinformationtab);
		return detailinformationtab;
	}
	
	@PutMapping("/{detail_information_id}")
	public void update(@PathVariable("detail_information_id")int detail_information_id, @Param("product_detail_id") int product_detail_id, 
			@Param("detail_information_picture") String detail_information_picture ) {
		detailinformationmapper.updateDetailInformationTab(product_detail_id, detail_information_picture);
		}
	
	@DeleteMapping("/{detail_quality_id}")
	public void delete(@PathVariable("detail_quality_id")int detail_quality_id){
		detailinformationmapper.deleteDetailInformationTab(detail_quality_id);
	}
}

