package com.shoppingmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.mapper.ProductsMapper;
import com.shoppingmall.model.Products;
import com.shoppingmall.service.ProductsService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsController {
	@Autowired
	ProductsService ps;

	@Autowired
	private ProductsMapper productsMapper;
	private String destPath = System.getProperty("java.io.tmpdir");

	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

	// 상품목록 전부보여줌
	@GetMapping("/all")
	public List<Products> getAll() {
		return productsMapper.getAll();
	}

	@GetMapping("/{product_id}")
	@ResponseBody
	public Products get(@PathVariable("product_id") int product_id) {
		return productsMapper.getProducts(product_id);
	}

	@PostMapping("")
	public Products insert(@RequestBody Products products) {
		productsMapper.insertProducts(products);
		return products;

	}

	@PutMapping("/{product_id}")
	public void update(@PathVariable("product_id") int product_id, @RequestBody Products products) {
	
		productsMapper.updateProducts(products);
	}

	@DeleteMapping("/{product_id}")
	public void delete(@PathVariable("product_id") int product_id) {
		productsMapper.deleteProducts(product_id);
	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam("category_id") int category_id,
			@RequestParam("product_name") String product_name,
			@RequestParam("product_description") String product_description,
			@RequestParam("product_price") int product_price, @RequestParam("stock") int stock,
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
			productsMapper.insertProducts(p);

			logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - ", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}



		
		@GetMapping("/showProductImage/{product_id}")
		@ResponseBody
		public ResponseEntity<?> downloadFile4(@PathVariable("product_id") int product_id, HttpServletResponse response,
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


	@GetMapping("/showInfoImage/{product_id}")
	@ResponseBody
	public ResponseEntity<?> downloadFile1(@PathVariable("product_id") int product_id, HttpServletResponse response,
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

	@GetMapping("/showQualityImage/{product_id}")
	@ResponseBody
	public ResponseEntity<?> downloadFile2(@PathVariable("product_id") int product_id, HttpServletResponse response,
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

}
