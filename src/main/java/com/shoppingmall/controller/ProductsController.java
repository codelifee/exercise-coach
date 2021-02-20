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

import com.shoppingmall.mapper.ProductsMapper;
import com.shoppingmall.model.Products;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsController {

	@Autowired
	private ProductsMapper productsMapper;

	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

	//모든 상품목록 전부보여줌
	@GetMapping("/all")
	public List<Products> getAll() {
		return productsMapper.getAll();
	}
	
	//이미지를 제외한 상품 목록 전부 보여줌
	@GetMapping("/allJsonData")
	public List<Products> allJsonData() {
		return productsMapper.getAllJsonData();
	}
	//이미지를 제외한 입력된 id와 매칭되는 상품 1개 보여줌
	@GetMapping("/allJsonData/{product_id}")
	public Products allJsonData(@PathVariable("product_id") int product_id) {
		return productsMapper.getAJsonData(product_id);
	}
	
	//입력된 id와 매칭되는 상품 1개 보여줌(이미지 포함)
	@GetMapping("/{product_id}")
	@ResponseBody
	public Products get(@PathVariable("product_id") int product_id) {
		return productsMapper.getProducts(product_id);
	}
	
	//입력된 id와 매칭되는 product_picture를 보여줌
	@GetMapping("/showProductImage/{product_id}")
	@ResponseBody
	public ResponseEntity<?> showProductImage(@PathVariable("product_id") int product_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			Products p = productsMapper.getProducts(product_id);
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");

			response.getOutputStream().write(p.getProduct_picture());
			response.getOutputStream().close();
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
}
	//입력된 id와 매칭되는 Info_img를 보여줌
	@GetMapping("/showInfoImage/{product_id}")
	@ResponseBody
	public ResponseEntity<?> showInfoImage(@PathVariable("product_id") int product_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			Products p = productsMapper.getProducts(product_id);
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
	
			response.getOutputStream().write(p.getInfo_img());
			response.getOutputStream().close();
			return new ResponseEntity<>("Product Saved With File", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//입력된 id와 매칭되는 Quality_img를 보여줌
	@GetMapping("/showQualityImage/{product_id}")
	@ResponseBody
	public ResponseEntity<?> showQualityImage(@PathVariable("product_id") int product_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			Products p = productsMapper.getProducts(product_id);
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
	
			response.getOutputStream().write(p.getQuality_img());
			response.getOutputStream().close();
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//이미지를 제외한 상품 데이터 모두 입력
	@PostMapping("")
	public Products insert(@RequestBody Products products) {
		productsMapper.insertProduct(products);
		return products;
	}
	
	//이미지 포함한 상품 데이터 모두 입력
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> upload(@RequestParam("category_id") int category_id,
			@RequestParam("product_name") String product_name,
			@RequestParam("product_description") String product_description,
			@RequestParam("product_price") int product_price, @RequestParam("stock") int stock, @RequestParam("status") String status,
			HttpServletRequest request, final @RequestParam("product_picture") MultipartFile product_picture,
			final @RequestParam("info_img") MultipartFile info_img,
			final @RequestParam("quality_img") MultipartFile quality_img) {

		logger.info(String.format("File name '%s' uploaded successfully.", product_picture.getOriginalFilename()));

		try {

			byte[] imageData = product_picture.getBytes();
			byte[] imageData1 = info_img.getBytes();
			byte[] imageData2 = quality_img.getBytes();

			Products p = new Products();

			p.setCategory_id(category_id);
			p.setProduct_description(product_description);
			p.setProduct_name(product_name);
			p.setProduct_picture(imageData);
			p.setInfo_img(imageData1);
			p.setQuality_img(imageData2);
			p.setProduct_price(product_price);
			p.setStock(stock);
			p.setStatus(status);
			productsMapper.insertProducts(p);

			logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//이미지 제외한 입력된 id와 매칭되는 상품 데이터 모두 수정 
	@PutMapping("/{product_id}")
	public void update(@RequestBody Products products) {
		productsMapper.updateProducts(products);
	}
	
	//이미지 제외한 입력된 id와 매칭되는 상품 데이터 부분 수정
	@PatchMapping("/{product_id}")
	   public @ResponseBody void patchProducts(@PathVariable int product_id, @RequestBody Map<Object, Object> fields) {
		Products products = productsMapper.getProducts(product_id);   
	      fields.forEach((k,v) -> {
	         Field field = ReflectionUtils.findRequiredField(Products.class, (String)k);
	         ReflectionUtils.setField(field, products, v);
	      });
	      productsMapper.updateProducts(products);
	   }
	
	//입력된 id와 매칭되는 상품 product_picture 수정
	@PatchMapping("/productPicture/{product_id}")
	public void updateProductPicture(@PathVariable("product_id") int product_id, @RequestParam("product_picture") MultipartFile product_picture) throws IOException {
		byte[] imageData=product_picture.getBytes();
		productsMapper.updateProductPicture(product_id, imageData);
	}
	
	//입력된 id와 매칭되는 상품 Info_img 수정
	@PatchMapping("/infoImg/{product_id}")
	public void updateInfoImg(@PathVariable("product_id") int product_id, @RequestParam("info_img") MultipartFile info_img) throws IOException {
		byte[] imageData=info_img.getBytes();
		productsMapper.updateInfoImg(product_id, imageData);
	}
	
	//입력된 id와 매칭되는 상품 Quality_img 수정
	@PatchMapping("/qualityImg/{product_id}")
	public void updateQualityImg(@PathVariable("product_id") int product_id, @RequestParam("quality_img") MultipartFile quality_img) throws IOException {
		byte[] imageData=quality_img.getBytes();
		productsMapper.updateQualityImg(product_id, imageData);		
	}
	
	//입력된 id와 매칭되는 상품 데이터 삭제
	@DeleteMapping("/{product_id}")
	public void delete(@PathVariable("product_id") int product_id) {
		productsMapper.deleteProducts(product_id);
	}

}
