package com.adith.CrudApplication.exceptions;

public class MailSendFailedException extends RuntimeException {
	
	public MailSendFailedException(String message){
		super(message);
	}

}
