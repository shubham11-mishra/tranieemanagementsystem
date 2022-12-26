package com.lexisnexis.tms.exceptions;

public class UserDoesNotExistException extends RuntimeException{
	
	String msg;
	
	public UserDoesNotExistException(String msg) {
	this.msg=msg;
	}
}
