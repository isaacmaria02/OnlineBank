package com.bank.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Profile;

@Service
public class EmailService {

	@Transactional
	public void sendEmail(String emailId, Profile user, String emailSubject, String emailMessage) {
		final String USER = "sbbibank005@gmail.com";// change accordingly
		final String PASS = "SBBI@2018";

		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER, PASS);
			}
		});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			message.setSubject(emailSubject);

			// message.setText("Your Account Number is : "+emailMessage);

			message.setContent(emailMessage, "text/html");

			// 3rd step)send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}