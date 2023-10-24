package com.wanted.employee.recruitment.exception;


import com.wanted.employee.support.exception.CustomException;
import com.wanted.employee.support.exception.ErrorCode;

public class Recruitment extends CustomException {
	public Recruitment() {
		super();
	}
	
	public Recruitment(String message) {
		super(message);
	}
	
	public Recruitment(String message, Throwable cause) {
		super(message, cause);
	}
	
	public Recruitment(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public Recruitment(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
}
