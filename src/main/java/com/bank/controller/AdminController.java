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
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@RequestMapping(value="/adminlogin",method = RequestMethod.POST)
	public ModelAndView openAccount(ModelAndView model, @ModelAttribute Admin admin, HttpSession session) {

		
		
		
		if(admin.getAdminId().equals("admin") && admin.getAdminPassword().equals("admin123"))
		{
			session.setAttribute("isAdminLoggedIn",true);
			
			System.out.println(session.getAttribute("isAdminLoggedIn"));
		
		    /*List<Profile> accountOpeningRequests = adminService.displayRequests();
			
			     model.addObject("requests",accountOpeningRequests);
			  
                 model.setViewName("AdminDashboard");	*/	
			
			model.setViewName("redirect:/display");
		}
		else {
        model.setViewName("Admin");
		}
		return model;

	}
	
	
	
	@RequestMapping(value="/display")
	public ModelAndView display(ModelAndView model) {

				
       	
			     
			    List<Profile> accountOpeningRequests = adminService.displayRequests();
			
			     model.addObject("requests",accountOpeningRequests);
			    
                 model.setViewName("AdminDashboard");			
		
		
		return model;

	}
	
	
	@RequestMapping(value="/adminlogout")
	public ModelAndView adminLogout(ModelAndView model, HttpSession session) {

		
		session.removeAttribute("isAdminLoggedIn");
       	session.invalidate();
       	
       	System.out.println("invaldated");
       	
       	model.setViewName("index");
			    	
		
		
		return model;

	}

	
	/* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/reject/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        int i = adminService.reject(id);   
        
        if(i>0)
        {
        	
        }
        else
        {
        	
        }
        	
        	
        return "redirect:/display";
	
        
    }   
    
    
	/* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/approve/{id}",method = RequestMethod.GET)    
    public String approve(@PathVariable int id){    
        int i = adminService.approve(id);   
        
        if(i>0)
        {
        	
        }
        else
        {
        	
        }
        	
        	
        return "redirect:/display";
	
        
    }
    
    
    
   


}
