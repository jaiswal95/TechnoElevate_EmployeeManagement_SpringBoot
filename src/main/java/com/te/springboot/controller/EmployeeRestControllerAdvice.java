package com.te.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot.bean.EmployeeResponse;
import com.te.springboot.excep.EmployeeExp;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(EmployeeExp.class)
	public EmployeeResponse getHandlerMethod(EmployeeExp exp) {

		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(500);

		response.setMsg(exp.getMessage());
		return response;

	}// end of EmployeeResponse

}// End of class
