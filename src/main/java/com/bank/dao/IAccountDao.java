package com.bank.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Profile;
/**
 * 
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 *
 */

/**
 * Interface for Account : Data Access Object
 */
public interface IAccountDao {

	public long getAccountNumber(Login login);
	
	public long createAccount(Customer customer, Account account, Address address);
	
	public int register(InternetBankingUser ibu) throws SQLIntegrityConstraintViolationException;
	
	public boolean login(Login login);

	
	public long getCustomerSeq(String query);
	
	public float checkBalance(long customerAccountNumber);
	
	public void emailAccountNumber(Customer customer, Account account, Address address);
	
	public Account getSummary(long customerAccountNumber);
	
	public Profile getProfileDetails(long customerAccountNumber);

	public boolean checkUserId(long customerAccountNumber, String oldId);
	
	public int changeUserId(long customerAccountNumber, String newId);
	
	public boolean checkLoginPassword(long customerAccountNumber, String oldPassword);
	
	public int changeLoginPassword(long customerAccountNumber, String newPassword);
	
	

	public boolean checkTransactionPassword(long customerAccountNumber,String oldTransactionPassword);

	public int changeTransactionPassword(long customerAccountNumber, String newTransactionPassword);


		
		
		
	

}
