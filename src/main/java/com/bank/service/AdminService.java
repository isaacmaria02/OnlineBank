package com.bank.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.AdminDao;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Admin;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminDao addao;
	


	@Transactional
	public List<Profile> displayRequests() {
		// TODO Auto-generated method stub
		return addao.displayRequests();
	}
	
	
	

	@Transactional
	public int reject(int customerId) {
		// TODO Auto-generated method stub
		return addao.reject(customerId);
		
		
		
		}
		
		
		
	
	
	
	
	
	

	@Transactional
	public int approve(int customerId) {
		// TODO Auto-generated method stub
			
			
		int isRequestApproved = addao.approve(customerId);
		Profile user = addao.getProfile(customerId);	
		
		System.out.println(user);
		System.out.println(user.getAccount_number());
		
				
		if(isRequestApproved>0)
		sendEmail(user.getEmail_id(), user.getAccount_number());             
		
		
		
		
			
		
		return isRequestApproved;
	}

	@Transactional
	public void sendEmail(String emailId, long accountNumber)
	{
		final String USER="sbbibank005@gmail.com";//change accordingly  
		final String PASS="SBBI@2018";  
		  
		//1st step) Get the session object    
		Properties props = new Properties();  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly  
		props.put("mail.smtp.auth", "true");  
		  
		Session session = Session.getDefaultInstance(props,  
		 new javax.mail.Authenticator() {  
		  protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(USER,PASS);  
		   }  
		});  
		//2nd step)compose message  
		try {  
		 MimeMessage message = new MimeMessage(session);  
		 message.setFrom(new InternetAddress(USER));  
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailId));  
		 message.setSubject("Congratulations ! Your SBBI account has been activated");  
		 message.setText("Your Account Number is : "+accountNumber);  
		   
		 //3rd step)send message  
		 Transport.send(message);  
		  
		 System.out.println("Done");  
		  
		 } catch (MessagingException e) {  
		    throw new RuntimeException(e);  
		 }  
	}
	
	
}