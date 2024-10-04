package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category c) {
		return new ResponseEntity<>(categoryRepository.save(c),HttpStatus.OK);
		
	}
	
	@GetMapping("/getCategory")
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}
}
