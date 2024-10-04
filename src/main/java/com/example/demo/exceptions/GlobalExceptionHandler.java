package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> exceptiondata(ProductNotFoundException ex){
		return new ResponseEntity<>("Unable to Find The Product",HttpStatus.NOT_FOUND);
	}}