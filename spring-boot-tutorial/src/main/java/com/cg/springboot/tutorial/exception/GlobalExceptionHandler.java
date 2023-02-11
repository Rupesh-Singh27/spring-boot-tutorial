package com.cg.springboot.tutorial.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<?> handleDepartmentNotFoundException(DepartmentNotFoundException departmentNotFoundException,
																WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), departmentNotFoundException.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
