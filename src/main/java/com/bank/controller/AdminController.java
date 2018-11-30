package com.bank.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

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
import com.bank.service.IAccountService;

@Controller
public class AdminController {

	@RequestMapping(value="/adminlogin",method = RequestMethod.POST)
	public ModelAndView openAccount(ModelAndView model, @ModelAttribute Admin admin) {

		
		
		
		
       
		if(admin.getAdminId().equals("admin") && admin.getAdminPassword().equals("admin123"))
		{
			
			     
			
			
			
                 model.setViewName("AdminDashboard");			
		}
		else {
        model.setViewName("Admin");
		}
		return model;

	}


}
