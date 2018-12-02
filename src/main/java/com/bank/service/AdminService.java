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
	
	@Autowired
	EmailService email;
	


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
		

		
		 String emailMessage = "Dear "+user.getFirst_name()+"<br/> Your SBBI Bank Account is Activated"+"<br/><br/>"+
		 "Please Register to avail the internet banking facility<br/><br/>"
		 +"Your Account Number is "+user.getAccount_number();
		 
		 String emailSubject = "Congratulations ! Your SBBI account has been activated";		
				
		if(isRequestApproved>0)
		
			{
			try {
				email.sendEmail(user.getEmail_id(), user, emailSubject, emailMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				isRequestApproved=-1;
			}           
		
			}
		
		
			
		
		return isRequestApproved;
	}

	
}