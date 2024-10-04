package com.adith.CrudApplication.services;

import org.springframework.stereotype.Service;

import com.adith.CrudApplication.exceptions.MailSendFailedException;

@Service
public class EmailSendServiceImpl implements EmailService {

	@Override
	public void sendSimpleEmail(String toEmail, String subject, String body) throws MailSendFailedException {
		try {
			Thread.sleep(10000);
			throw new MailSendFailedException("failed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
