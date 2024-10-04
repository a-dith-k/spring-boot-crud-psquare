package com.adith.CrudApplication.services;

import com.adith.CrudApplication.exceptions.MailSendFailedException;

public interface EmailService {
	
	
	void sendSimpleEmail(String toEmail,String subject,String body) throws MailSendFailedException;

}
