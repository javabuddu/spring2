package com.spring.rest.jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private String errorCode;
	private String errorMsg;

}
