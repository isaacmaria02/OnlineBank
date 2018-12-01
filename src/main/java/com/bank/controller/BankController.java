package com.bank.controller;
import java.util.logging.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.AccountDao;
import com.bank.dao.IReportGeneration;
import com.bank.model.Account;
import com.bank.model.AccountNumber;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;
import com.bank.model.Transaction;
import com.bank.service.IAccountService;
import com.bank.service.IFundTransferService;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Isaac Maria  <isaac.m@somaiya.edu>
 */
@Controller
public class BankController {
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IFundTransferService fundTransferService;

	@Autowired
	private IReportGeneration reportGenerationService;

	@RequestMapping(value="/open",method = RequestMethod.POST)
	public ModelAndView openAccount(ModelAndView model, @ModelAttribute Customer customer, Account account,
			Address address) {



		long accountNum = accountService.openAccount(customer, account, address);

		if (accountNum > 0) {
			model.setViewName("AccountInformation");
			
			model.addObject("user_account_number",accountNum);
			
			model.addObject("notification","Account created successfully");
		} else {
			model.addObject("notification", "Could not create your account");
			model.setViewName("OpenAccount");
		}

		return model;

	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView register(ModelAndView model, @ModelAttribute InternetBankingUser ibu) {

		
		

		// REGISTER IF IT EXISTS
		int i = accountService.registerOnline(ibu);

		if (i > 0) {

			model.setViewName("Login");

		} else
			model.setViewName("Register");

		return model;

	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView model, @ModelAttribute Login login, HttpSession session) {

		if (accountService.validateUser(login)) {

			long accountNumber = accountService.getAccountNumber(login);

			session.setAttribute("account_number", accountNumber);
			session.setAttribute("isLoggedIn",true);

			model.setViewName("Dashboard");

		} else {
			
			model.setViewName("Login");

		}

		return model;

	}
	
	/**
	 * 
	 * @param model
	 * @param session : It has IsLoggedSession set to true which will be invalidated when 
	 * logout button is pressed and customer will be redirected to the homepage
	 * @return 
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(ModelAndView model, HttpSession session) {

		session.invalidate();
		model.setViewName("index");
		
		
		return model;

	}

	@RequestMapping("/addPayee")
	public ModelAndView addPayee(ModelAndView model, @ModelAttribute Payee payee, HttpSession session) {

		System.out.println(payee);
		payee.setCustomer_account_number((Long) session.getAttribute("account_number"));

		int i = fundTransferService.addPayee(payee);

		if (i > 0)
		{
			model.addObject("payee_status", "Payee added successfully");

			model.setViewName("Dashboard");
		}
		else
			model.setViewName("Payee");

		return model;

	}

	@RequestMapping("/DeletePayee")
	public ModelAndView deletePayee(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {

		System.out.println("in controller " + session.getAttribute("account_number"));

		int i = fundTransferService.deletePayee(request.getParameter("payee_name"),
				(Long) session.getAttribute("account_number"));

		if (i > 0) {
			model.addObject("payee_status", "Payee Deleted Successfully");
			
			

			model.setViewName("Dashboard");
		} else {
			model.addObject("payee_status", "Does not exist");
			model.setViewName("Dashboard");
		}

		return model;

	}

	@RequestMapping("/DisplayPayee")
	public ModelAndView displayPayee(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {


		List<Payee> payeeList = fundTransferService.displayPayee((Long) session.getAttribute("account_number"));

		model.addObject("PayeeList", payeeList);
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/FundTransfer")
	public ModelAndView fundTransfer(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session) {


		List<Payee> payeeList = fundTransferService.displayPayee((Long) session.getAttribute("account_number"));

		//System.out.println(payeeList.size());
		
		model.addObject("PayeeList", payeeList);

		model.setViewName("FundTransferForm");

		return model;

	}

	@RequestMapping("/ConfirmPayment")
	public ModelAndView confirmTransaction(HttpServletRequest request, HttpServletResponse response, ModelAndView model,
			HttpSession session, @ModelAttribute Transaction tr) {




		boolean isSuccessful = fundTransferService.confirmTransaction(tr,
				(Long) session.getAttribute("account_number"));

		if (isSuccessful) {
			model.addObject("transaction","Fund Transfer Successful");
			model.setViewName("Dashboard");
			
		} else {
	       model.addObject("transaction","Transaction Failure");

			model.setViewName("Dashboard");
		}


		return model;

	}
	
	
	
	
	@RequestMapping("/summary")
	public ModelAndView accountSummary(ModelAndView model, HttpSession session) {
		// float balance = accountService.getBalance((Long) session.getAttribute("account_number"));
		
         Account userAccount = accountService.getSummary((Long) session.getAttribute("account_number"));
		
		// model.addObject("balance", balance);
    
         
         model.addObject("summary", userAccount);
         
         
         
         model.setViewName("AccountSummary");
       



		return model;

	}

	@RequestMapping("/AccountStatement")
	public ModelAndView getAccountStatement(HttpServletRequest request, HttpServletResponse response,
			ModelAndView model, HttpSession session) {


		String fromDate = request.getParameter("from");
		String toDate = request.getParameter("to");

		SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat requiredFormat = new SimpleDateFormat("dd-MMM-yy");
		Date from = null;
		Date to = null;
		try {
			from = current.parse(fromDate);
			to = current.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fromDate = requiredFormat.format(from);
		toDate = requiredFormat.format(to);
		
		session.setAttribute("from", fromDate);
		session.setAttribute("to", toDate);


		List<Transaction> accountStatement = reportGenerationService.getAccountStatement(fromDate, toDate,
				(Long) session.getAttribute("account_number"));

		if(accountStatement.size()!=0) {
		model.addObject("AccountStatementList", accountStatement);
        
		}
		else
		{ 
			model.addObject("statement","No Results Found");
		
		}
		model.setViewName("AccountStatement");

		return model;

	}
	
	
	@RequestMapping("/details")
	public ModelAndView accountDetails(ModelAndView model, HttpSession session) {
			
		
         Profile userProfile = accountService.getDetails((Long) session.getAttribute("account_number"));
         
         model.addObject("user_profile",userProfile);
         
         System.out.println(userProfile);
         
         model.setViewName("AccountDetails");
       



		return model;

	}
	
	
	
	@RequestMapping("/changeId")
	public ModelAndView changeId(ModelAndView model, HttpSession session) {
			
		
         



		return model;

	}
	
	
	@RequestMapping("/download")
	public ModelAndView generateStatement(ModelAndView model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	
		
        Profile userProfile = accountService.getDetails((Long) session.getAttribute("account_number"));
      
    	List<Transaction> accountStatement = reportGenerationService.getAccountStatement((String)session.getAttribute("from"),(String)session.getAttribute("to"),
				(Long) session.getAttribute("account_number"));
        
        
        
        XWPFDocument document = new XWPFDocument(); 
		
              	    try{
              	    	File file = new File("C:\\Users\\AE103_PC7\\git\\OnlineBank\\src\\main\\resources\\"+userProfile.getAccount_number());
          	        	session.setAttribute("filePath","C:\\Users\\AE103_PC7\\git\\OnlineBank\\src\\main\\resources\\"+userProfile.getAccount_number()+"\\");

              	    	if (!file.exists()) {
              	        	//model.addObject("filePath",file);
              	        	
              	            if (file.mkdir()) {
              	                System.out.println("Directory is created!");
              	            } else {
              	                System.out.println("Failed to create directory!");
              	            }
              	        }
              	    	
              	    	
        	    	FileOutputStream out = new FileOutputStream(new File(file+"/"+(String)session.getAttribute("from")+"-"+(String)session.getAttribute("to")+".docx"));
        		//	model.addObject("fileName",(String)session.getAttribute("from")+"-"+(String)session.getAttribute("to")+".docx");
        	    	session.setAttribute("fileName", (String)session.getAttribute("from")+"-"+(String)session.getAttribute("to")+".docx");
        	    	
        	    	//TITLE
        	        XWPFParagraph paragraph = document.createParagraph();
        	        XWPFRun run = paragraph.createRun();

        		      run.setFontSize(18);
        		      paragraph.setAlignment(ParagraphAlignment.CENTER);
        		      run.setText("STATEMENT OF ACCOUNT");
        		      
        		      //DETAILS
        		      paragraph = document.createParagraph();
        		      run = paragraph.createRun();        		      
        		      run.setText("Account Number : "+userProfile.getAccount_number());
        		      run.addBreak();
        		      run.setText("Balance : "+userProfile.getBalance());
        		      run.addBreak();
        		      run.setText("Customer ID: "+userProfile.getCustomer_id());
        		      run.addBreak();
        		      run.setText("Customer Name: "+userProfile.getFirst_name()+" "+userProfile.getLast_name());
        		      run.addBreak();
        		      run.setText("Address: "+userProfile.getAddress_line_1()+","+userProfile.getAddress_line_2());
                      run.addBreak();
                      
             
                      //create table
                      XWPFTable table = document.createTable();
                		
                      //create first row
                      XWPFTableRow tableRowOne = table.getRow(0);
                      
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      tableRowOne.addNewTableCell();
                      
                      
                      tableRowOne.getCell(0).setText("Reference ID");                 
                      tableRowOne.getCell(1).setText("Transaction Type");
                      tableRowOne.getCell(2).setText("Amount");
                     tableRowOne.getCell(3).setText("From Account");
                      tableRowOne.getCell(4).setText("To Account");
                      tableRowOne.getCell(5).setText("Date");
                      tableRowOne.getCell(6).setText("Remark");
                      tableRowOne.getCell(7).setText("Transaction Charges");
                      tableRowOne.getCell(8).setText("Status");
                      
                    

                      

                     XWPFTableRow tableRow ;
                      for(int i = 0; i<accountStatement.size(); i++) {
                      tableRow = table.createRow();

                      
                      tableRow.getCell(0).setText(""+accountStatement.get(i).getReference_id());               
                      tableRow.getCell(1).setText(""+accountStatement.get(i).getType());
                      tableRow.getCell(2).setText(""+accountStatement.get(i).getAmount());
                      tableRow.getCell(3).setText(""+accountStatement.get(i).getFrom_account());
                      tableRow.getCell(4).setText(""+accountStatement.get(i).getTo_account());
                      tableRow.getCell(5).setText(""+accountStatement.get(i).getTimestamp());

                      
             
                      if(accountStatement.get(i).getRemark()==null)
                      {
                          tableRow.getCell(6).setText("");

                      }
                      else
                      {
                          tableRow.getCell(6).setText(""+accountStatement.get(i).getRemark());

                      }
                  
                    	   
                      
                      tableRow.getCell(7).setText(""+accountStatement.get(i).getCharges());
                      tableRow.getCell(8).setText(""+accountStatement.get(i).getStatus());
                      }
        	    	
        	    	
                      
                    
        	    	
        	    	
        	    	
        	    	document.write(out);
        			out.close();
        	    }
        	    catch (IOException e){
        	        e.printStackTrace();
        	        System.out.println("Not successful");
        	        System.exit(-1);
        	    }
        	
       
        
        
        

        model.setViewName("Download");
		return model;

	}
	
	
	
	
	

}
