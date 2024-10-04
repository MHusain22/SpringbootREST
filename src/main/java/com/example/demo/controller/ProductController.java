package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200/")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
//	@PreAuthorize("hasRole('USER')")
	@GetMapping("/retrieve")
	public List<Product> retrieveData() {
		return productRepository.findAll();
	}
	
	@PostMapping("/insertData")
	public Product insertData(@RequestBody Product p) {
		return productRepository.save(p);
	}

	
	
	//by id
	@GetMapping("/retreiveProducts/{pid}")
	public ResponseEntity<Product>
	getDataByProductid(@PathVariable("pid") int productid)
	{
		Product p = productRepository.findById(productid).orElseThrow(()->new ProductNotFoundException());
		if(p!=null) {
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
		}
	}
	
	//by name
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/retrieveData/{pname}")
	public Product getProductByName(@PathVariable("pname") String productname) {
		return productRepository.findByProductname(productname);
	}
	
	//by id and name
	@GetMapping("/retrieveDataByIdandName/{id}/{pname}")
	public List<Product> getProductByName(@PathVariable("id") int productid,@PathVariable("pname") String productname) {
		return productRepository.findByProductidAndProductname(productid,productname);
	}
	
	//sort product
	@GetMapping("/sortPrice/{item}")
	public List<Product> getPriceSorted(@PathVariable("item") String item) {
		if(item.equals("low")) {
			return productRepository.findByOrderByPriceAsc();			
		} else {
			return productRepository.findByOrderByPriceDesc();
		}
	}
	
	@PutMapping("/updateProduct/{productid}")
	public Product updateProductById(@PathVariable("productid") int productid,@RequestBody Product p) {
		Product updatedProduct = null;
		Optional<Product> productdata = productRepository.findById(productid);
		if(productdata.isPresent()) {
			updatedProduct = productdata.get();
			updatedProduct.setProductname(p.getProductname());
			updatedProduct.setPrice(p.getPrice());
			updatedProduct.setQuantity(p.getQuantity());
		}
			return productRepository.save(p);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public void deleteData(@PathVariable("id") int id) {
		System.out.println("Deleting "+id);
		productRepository.deleteById(id);
	}
	
	@GetMapping("/getTotal")
	public int getTotal() {
		List<Product> productdata = productRepository.findAll();
		int total = 0;
		for(Product p:productdata) {
			total += p.getPrice()*p.getQuantity();
		}
		return total;
	}

}
