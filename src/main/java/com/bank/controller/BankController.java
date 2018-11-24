package com.bank.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.AccountDao;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.service.IAccountService;

@Controller
public class BankController
{
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/open")
	public ModelAndView openAccount(ModelAndView model, @ModelAttribute Customer customer, Account account, Address address)
	{
		
		account.setCustomer_id(customer.getCustomer_id());
		System.out.println(customer);
		System.out.println(account);
		System.out.println(address);
		
	   int i =  accountService.openAccount(customer,account,address);
		
	//	int i = edao.createAccount(customer, account, address);
		
		model.setViewName("Dashboard");
		
		return model;
		
		
		
		
	}
	
	
	@RequestMapping("/register")
	public ModelAndView register(ModelAndView model, @ModelAttribute InternetBankingUser ibu)
	{
		
      
		
		int i = accountService.registerOnline(ibu);
		
		if(i>0)
		model.setViewName("Login");
		
		else
			model.setViewName("Register");
		
		
		return model;
		
		
		
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView model, @ModelAttribute Login login)
	{
		
		

		if(accountService.validateUser(login))
		{
			model.setViewName("Dashboard");

		}
		else
		{
			model.setViewName("Login");

		}
		
		
		
		
		
		return model;
		
		
		
		
	}
	
	
	
	
	/*
	@RequestMapping("/checkBal")	
	public ModelAndView Check(HttpServletRequest request,HttpServletResponse response, @ModelAttribute RechargeForm rf) throws ServerException,IOException
	{

	//	RechargeForm r  = rf;
	System.out.println("inside check "+rf.getAmount()+" "+rf.getUserId());
		User u= edao.checkBalance(rf);
		//System.out.println("checked bal"+u.getBalance()+" "+rf.getAmount());
		if(u.getBalance()>rf.getAmount())
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("obj",rf);
			ses.setAttribute("user", u);
			
			return new ModelAndView("confirm");

			
			

			//System.out.println("save");
		}
		else
		{
			return new ModelAndView("error");

		}
	}
	
	
	@RequestMapping("/rechargeNow")
	public ModelAndView Save(HttpServletRequest request,HttpServletResponse response )throws ServerException,IOException
	{
		System.out.println("test2....");
		
		HttpSession ses = request.getSession();
		RechargeForm rf = (RechargeForm)ses.getAttribute("obj");
		User u = (User) ses.getAttribute("user");
		
		
		int j = edao.updateBalance(u.getBalance()-rf.getAmount(), rf);
		
		System.out.println("got user session"+u.getBalance());
		if(j>0)
		{
			
		
		}
		else
		{
			return new ModelAndView("recharge");
		}
		
		
		
		int i = edao.saveTransaction(rf);
		
		if(i>0)
		{
			return new ModelAndView("sucess");
		}
		else
		{
			System.out.println("not save..");
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping("/display")
	public ModelAndView DisplayAll(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RechargeForm rf) throws ServerException,IOException, ServletException
	{
		System.out.println("test in display");
		List<RechargeForm> lst = new ArrayList<RechargeForm>();
		lst = edao.getAllTransaction(rf);
		request.setAttribute("transactionList",lst);
		HttpSession session = request.getSession();
		session.setAttribute("transactionList",lst);

		HttpSession ses = request.getSession();
		ses.setAttribute("transactionList", lst);	
		
		return new ModelAndView("display");
	}
	*/
	/*
		@RequestMapping("/viewemp")  
	    public ModelAndView viewemp(){  
	        List<Employee> list=edao.getAllEmployees();  
	        return new ModelAndView("viewemp","list",list);  
	    }  
		
		@RequestMapping(value="/editemp/{fname}")  
	    public ModelAndView edit(@PathVariable String fname){  
	        Employee emp=edao.getEmpByFname(fname);  
	        return new ModelAndView("empeditform","command",emp);  
	    }  
	
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
	        edao.update(emp);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
	  
	  @RequestMapping(value="/deleteemp/{fname}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable String fname){  
	        edao.delete(fname);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  */
	
	
}
