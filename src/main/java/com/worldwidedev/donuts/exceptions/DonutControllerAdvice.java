package com.worldwidedev.donuts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class DonutControllerAdvice {
//	@ResponseBody
//	@ExceptionHandler(DonutNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	String donutNotFoundHandler(DonutNotFoundException e) {
//		return e.getMessage();
//	}
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseBody
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public void processValidationError(MethodArgumentNotValidException ex) {
//		
//	}
}
