package com.cjc.webApp.Exception_responce;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.webApp.Entity.BaseResponse;
import com.cjc.webApp.Entity.User;
import com.cjc.webApp.Exception.UserNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<BaseResponse<User>> handleUsernotFound(){
		return new ResponseEntity<BaseResponse<User>>( new BaseResponse<User>(404,"USER NOT FOUND", new Date(),null),HttpStatus.NOT_FOUND);
		
	}

}
