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

import com.shoppingmall.mapper.AdministratorMapper;
import com.shoppingmall.model.Administrator;


@RestController
@RequestMapping("/administrator")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdministratorController {

	@Autowired
	private AdministratorMapper administratorMapper;
	
	@PostMapping("")
	public Administrator insert(@RequestBody Administrator administrator) {
		administratorMapper.insertAdministrator(administrator);
		return administrator;
	}

	@GetMapping("/all")
	public List<Administrator> getAll(){
		return administratorMapper.getAll();
	}
	
	@GetMapping("/{administrator_id}")
	public Administrator get(@PathVariable("administrator_id")String administrator_id) {
		return administratorMapper.getAdministrator(administrator_id);
	}
	
	@PutMapping("/{administrator_id}")
	public void update(@RequestBody Administrator administrator) {
		administratorMapper.updateAdministrator(administrator);
	}
	
	@PatchMapping("/{administrator_id}")
	public @ResponseBody void patchAdministrator(@PathVariable String administrator_id, @RequestBody Map<Object, Object> fields) {
		Administrator administrator = administratorMapper.getAdministrator(administrator_id);
		fields.forEach((k,v) -> {
			Field field = ReflectionUtils.findRequiredField(Administrator.class, (String)k);
			ReflectionUtils.setField(field, administrator, v);
		});
		administratorMapper.updateAdministrator(administrator);
	}
	
	@DeleteMapping("/{administrator_id}")
	public void delete(@PathVariable("administrator_id")String administrator_id){
		administratorMapper.deleteAdministrator(administrator_id);
	}
		
}
