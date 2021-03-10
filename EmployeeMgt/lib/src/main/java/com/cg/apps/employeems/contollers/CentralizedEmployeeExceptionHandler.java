package com.cg.apps.employeems.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.employeems.exceptions.EmployeeNotFoundException;
import com.cg.apps.employeems.exceptions.InvalidIdException;
import com.cg.apps.employeems.exceptions.NameNotValidException;

@RestControllerAdvice
public class CentralizedEmployeeExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidIdException.class)
	public String handleInvalidIdException(InvalidIdException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NameNotValidException.class)
	public String handleNameNotValidException(NameNotValidException e) {
		return e.getMessage();
	}
}
