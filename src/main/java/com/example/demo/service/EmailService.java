package com.example.demo.service;



import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;



@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String email,String token)

	{

		MimeMessage message =  this.mailSender.createMimeMessage();

		MimeMessageHelper mimeHelper;

		try {

			mimeHelper = new MimeMessageHelper(message,true);

			mimeHelper.setTo(email);

			

			

			mimeHelper.setFrom("smtp.gmail.com");

			mimeHelper.setSubject("Password Reset");
			
			

			mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/reset-password2?token="+token+"&&email="+email+"'> Click here</a> to reset password</body></html>",true);

			mailSender.send(message);

		} catch (MessagingException e) {

			System.out.println("Error Sending email "+ e.getMessage());

		}

		

	}

}
