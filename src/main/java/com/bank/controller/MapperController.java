package com.bank.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.AdminDao;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Admin;
import com.bank.model.Customer;
import com.bank.model.Profile;
import com.bank.service.AdminService;
import com.bank.service.IAccountService;

@Controller
public class MapperController {
	


	@RequestMapping("/addPayeePage")
	public ModelAndView addPayeeMap(ModelAndView model) {

		
		model.addObject("AddPayeeView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}
	
	

	@RequestMapping("/deletePayeePage")
	public ModelAndView deletePayeeMap(ModelAndView model) {

		
		model.addObject("DeletePayeeView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}
	
	

	@RequestMapping("/changeIdPage")
	public ModelAndView changeIdPage(ModelAndView model) {

		
		model.addObject("ChangeIdView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}
	
	@RequestMapping("/changePasswordPage")
	public ModelAndView changePassword(ModelAndView model) {

		
		model.addObject("ChangePasswordView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}

	
	@RequestMapping("/changeTransactionPasswordPage")
	public ModelAndView changeTransactionPassword(ModelAndView model) {

		
		model.addObject("ChangeTransactionPasswordView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}
	
	
	@RequestMapping("/accountStatementPage")
	public ModelAndView accountStatement(ModelAndView model) {

		
		model.addObject("AccountStatementView","not empty");
		model.setViewName("Dashboard");
		
	
		
		return model;

	}
	
	

	
        
    }
    
    
    
   



