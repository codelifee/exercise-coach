package com.shoppingmall;

import javax.annotation.Resource;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.shoppingmall.model.Users;
import com.shoppingmall.uploadmultiple.service.FilesStorageService;

@MappedTypes(Users.class)
@MapperScan("com.shoppingmall.mapper")
@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {
	
	 @Resource
	  FilesStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
	    storageService.init();
		
	}
	
	

}
