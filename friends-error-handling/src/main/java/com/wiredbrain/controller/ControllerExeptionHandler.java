package com.wiredbrain.controller;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wiredbrain.util.ErrorMessage;


@ControllerAdvice
public class ControllerExeptionHandler {
	@ResponseBody
	@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	ErrorMessage exceptionHandler(ValidationException e)
	{
		return new ErrorMessage("400",e.getMessage() );
	}

}
