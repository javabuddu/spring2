package com.spring.rest.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	/*@ExceptionHandler(EmployeeDtlsNotFoundException.class)
	@ResponseStatus
	public @ResponseBody ErrorResponse exception(EmployeeDtlsNotFoundException exception) {
		ErrorResponse errorRes=new ErrorResponse();
		errorRes.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		errorRes.setErrorMsg(exception.getMessage());// your custom message 
		return errorRes;
	}*/
	
	
	/*@ExceptionHandler(EmployeeDtlsNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeDtlsNotFoundException exception) {
		return new ResponseEntity<>("Employee not found :: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
	}*/
	
	
	@ExceptionHandler(EmployeeDtlsNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeDtlsNotFoundException exception) {
		ErrorResponse errorRes=new ErrorResponse();
		errorRes.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		errorRes.setErrorMsg(exception.getMessage());// your custom message 
		return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> exception(IdNotFoundException exception) {
		ErrorResponse errorRes=new ErrorResponse();
		errorRes.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		errorRes.setErrorMsg(exception.getMessage());// your custom message 
		return new ResponseEntity<>(errorRes, HttpStatus.NOT_FOUND);
	}
	 
	

}
