package com.shoppingmall;

import javax.sql.DataSource;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shoppingmall.model.Users;

@MappedTypes(Users.class)
@MapperScan("com.shoppingmall.mapper")
@SpringBootApplication
public class PortfolioApplication {
	
	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOriginPatterns("*");
	         }
	      };
	   }
	
/*	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    return sessionFactory.getObject();
	}*/
	
	
}

