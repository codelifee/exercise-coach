package com.shoppingmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.mapper.ProductDetailsMapper;
import com.shoppingmall.model.ProductDetails;

@RestController
@RequestMapping("/productsDetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);
	
	@Autowired
	private ProductDetailsMapper productDetailsMapper;

	@GetMapping("/all")
	public List<ProductDetails> getAll(){
		return productDetailsMapper.getAll();
	}
	
	@GetMapping("/{product_detail_id}")
	public ProductDetails get(@PathVariable("product_detail_id")int product_detail_id) {
		return productDetailsMapper.getProductDetails(product_detail_id);
	}
	
	@PostMapping("")
	public ProductDetails insert(@RequestBody ProductDetails productDetails) {
		productDetailsMapper.insertProductDetails(productDetails);
		return productDetails;
	}
	
	@PutMapping("/{product_detail_id}")
	public void update(@PathVariable("product_detail_id")int product_detail_id, @Param("product_id") int product_id,
			@Param("product_color") String product_color, @Param("product_stock") int product_stock,@Param("product_stock") String product_size,
			@Param("info_image") MultipartFile info_image, @Param("quality_image")  MultipartFile quality_image) throws IOException {
		byte[] imageData1=info_image.getBytes();
		byte[] imageData2=quality_image.getBytes();
		productDetailsMapper.updateProductDetails(product_detail_id, product_id, product_color, product_size, imageData1, imageData2);
		
	}
	
	@DeleteMapping("/{product_detail_id}")
	public void delete(@PathVariable("product_detail_id")int product_detail_id){
		productDetailsMapper.deleteProductDetails(product_detail_id);
	}
	
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam("product_id") int product_id,
	        @RequestParam("product_color") String product_color,@RequestParam("product_size") String product_size,
	        HttpServletRequest request, @RequestParam("info_iamge") MultipartFile info_iamge,
	        final @RequestParam("quality_image") MultipartFile quality_image) {

	     logger.info(String.format("File name '%s' uploaded successfully.", info_iamge.getOriginalFilename()));  
	     logger.info(String.format("File name '%s' uploaded successfully.", quality_image.getOriginalFilename()));  

	     try {

	    	  byte[] infoImage = info_iamge.getBytes();
	    	  byte[] QualityImage = quality_image.getBytes();
	        
	    	  ProductDetails p = new ProductDetails();

	    	  p.setProduct_id(product_id);
	    	  p.setProduct_color(product_color);
	    	  p.setProduct_size(product_size);
	    	  p.setInfo_image(infoImage);
	    	  p.setQuality_image(QualityImage);
	    	  productDetailsMapper.insertProductDetails(p);

	        logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
	        return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);

	     }catch (Exception e) {
	        e.printStackTrace();
	        logger.info("Exception: " + e);
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	  }
	
	   @GetMapping("/show/info_image/{product_detail_id}")
	   @ResponseBody
	   public ResponseEntity<?> downloadInfoImage(@PathVariable("product_detail_id") int product_detail_id, HttpServletResponse response,
	         HttpServletRequest request) throws IOException, SQLException {
	      try {
	         ProductDetails p = productDetailsMapper.getProductDetails(product_detail_id);
	         response.setContentType("image/jpeg; image/jpg; image/png; image/gif");

	        	 response.getOutputStream().write(p.getInfo_image());
		         response.getOutputStream().close();

	         return new ResponseEntity<>("Downloaded File - ", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         logger.info("Exception: " + e);
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	      }
	   }
	
	@GetMapping("/show/quality_image/{product_detail_id}")
	@ResponseBody
	public ResponseEntity<?> downloadQualityImage(@PathVariable("product_detail_id") int product_detail_id, HttpServletResponse response,
			HttpServletRequest request) throws IOException, SQLException {
		try {
			ProductDetails p = productDetailsMapper.getProductDetails(product_detail_id);
			response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
			
			response.getOutputStream().write(p.getQuality_image());
			response.getOutputStream().close();
			
			return new ResponseEntity<>("Downloaded File - ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
