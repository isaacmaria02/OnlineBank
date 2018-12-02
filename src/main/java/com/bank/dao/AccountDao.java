package com.bank.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Account;
import com.bank.model.AccountNumber;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.MD5;
import com.bank.model.Payee;
import com.bank.model.Profile;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.activation.*;
/**
 * 
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 *
 */

public class AccountDao implements IAccountDao
{
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Autowired
	MD5 hash;
	
	/**
	 * Processes the open account request from the user
	 * <p> The open account form is validated and then inserted into Customers, Accounts and Addresses relation
	 * </p>
	 * @param customer : Fetches values from the getters of model class Customers
	 * @param account : Fetches values from the getters of Model class Accounts
	 * @param address : Fetches values from the getters of Model class Addresses
	 * @return long : return the account number if the record is updated
	 */
	public long createAccount(Customer customer, Account account, Address address)
	{
		int i=0,j=0,k=0;

		String getCustomerId= "select GR13_customers_seq.nextval from dual";
		long customerId = getCustomerSeq(getCustomerId);


		String getAccountNumber= "select GR13_accounts_seq.nextval from dual";
		long accountNumber = getCustomerSeq(getAccountNumber);


		String getAddressId= "select GR13_addresses_seq.nextval from dual";
		long addressId = getCustomerSeq(getAddressId);


		String customerTableQuery="insert into GR13_customers values("+customerId+",'"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"',"+customer.getMobile_number()+","+customer.getAadhar_card()+",'"+customer.getDate_of_birth()+"',"+customer.getAnnual_income()+",'pending')";


		//ADD ALL THE CONDITIONS

		i= jdbcTemplate.update(customerTableQuery);




		String accountTableQuery="insert into GR13_accounts values("+accountNumber+",500000,'SAVINGS',"+customerId+")";

		i =  jdbcTemplate.update(accountTableQuery);



		String addressTableQuery="insert into GR13_addresses values("+addressId+",'"+address.getAddress_line_1()+"','"+address.getAddress_line_2()+"',"+address.getPin_code()+",'"+address.getCity()+"','"+address.getState()+"',"+customerId+")";

		//	String query="insert into customers values('"+rf.getUserId()+"','"+rf.getMobileNo()+"','"+rf.getAmount()+"','"+rf.getOperator()+"')";

		i =  jdbcTemplate.update(addressTableQuery);


		if(i<=0)
		{
			//accountNumber=0;
			return 0;
		}

		//EMAIL ACCOUNT NUMER
	//	emailAccountNumber(customer, account, address);
		
/*		
		AccountNumber registeredUser = new AccountNumber();
        System.out.println(accountNumber+" inside account dao");
        registeredUser.setAccountNumber(accountNumber);
		*/
		return accountNumber;
	}


	//search account number before this
/**
 * User will register for internet banking after account opening process is complete
 * <p>
 * Account Number will be emailed to user after the admin approves the account opening request. The customer can
 * use the account number for availing internet banking.
 * 
 * @param InternetBankingUser : It is a model class obtained from Internet Banking registation form.
 * @return int : return positive values when successfully registered for internet banking
 * </p>
 */
	public int register(InternetBankingUser ibu)
	{
		int i =0;
		
				
		
		i= jdbcTemplate.update("insert into GR13_internet_banking_users values(?,?,?,?,?,?,?,?)", new Object[] {ibu.getUser_id(), ibu.getLogin_password(), ibu.getTransaction_password(),0,"enabled", ibu.getSecurity_questions(), ibu.getSecurity_answers(), ibu.getAccount_number()});		
		
			
		
		
				return i;

	}


	public boolean login(Login login)
	{


		String validateUserQuery = "select * from GR13_internet_banking_users where GIBU_USER_ID='" + login.getUser_id() + "' and GIBU_LOGIN_PASSWORD='" + hash.getMd5(login.getPassword()) +"'";
		List<InternetBankingUser> users = jdbcTemplate.query(validateUserQuery, new UserMapper());
		
		
		
		
		return users.size() > 0 ? true : false;



	}


	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub



		String getAccountNumberQuery="select GIBU_GA_ACCOUNT_NUMBER from gr13_internet_banking_users where gibu_user_id='"+login.getUser_id()+"'"; 

		long accountNumber =jdbcTemplate.queryForObject(getAccountNumberQuery, Long.class); 	 

		return accountNumber;


	}



	public long getCustomerSeq(String query) {

		long res = jdbcTemplate.queryForObject(query, Long.class);
		return res;
	}


	class UserMapper implements RowMapper<InternetBankingUser> {
		public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			InternetBankingUser user = new InternetBankingUser();
		

			user.setUser_id(rs.getString(1));
			user.setLogin_password(rs.getString(2));


			return user;
		}

	}

	
	public float checkBalance(long customerAccountNumber){  
		String getBalanceQuery="select ga_balance from gr13_accounts where ga_account_number="+customerAccountNumber; 



		float balance = jdbcTemplate.queryForObject(getBalanceQuery, Float.class); 	 

		return balance;
	}
	
	


	/*public  void emailAccountNumber(Customer customer, Account account, Address address)
	{
		String to = customer.getEmail_id();
		System.out.println(to);

		// Sender's email ID needs to be mentioned
		String from = "isaac.m@somaiya.edu";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", "8082");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Your Account is Activated!");

			// Send the actual HTML message, as big as you like
			message.setContent("<h1>Your Account Number is "+account.getAccount_number()+"</h1>", "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}*/
	
	/**
	 * @param customerAccountNumber : It is used as a parameter to obtain summary information of the customer
	 * @return Account : returns the Account Summary Model object
	 */
	@Override
	public Account getSummary(long customerAccountNumber) {
		// TODO Auto-generated method stub
		
		String getSummaryQuery="select * from gr13_accounts where ga_account_number="+customerAccountNumber; 



		Account userAccount = jdbcTemplate.queryForObject(getSummaryQuery, new AccountMapper()); 	 
		
		
		return userAccount;
	}
	
	
	class AccountMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int arg1) throws SQLException {
			Account user = new Account();
		
			user.setCustomer_id(rs.getLong(4));
			user.setAccount_number(rs.getLong(1));
			user.setBalance(rs.getFloat(2));
            user.setAccount_type(rs.getString(3));


			return user;
		}

	}
	
	class ProfileMapper implements RowMapper<Profile> {
		public Profile mapRow(ResultSet rs, int arg1) throws SQLException {
			Profile user = new Profile();
		
			user.setCustomer_id(rs.getInt(1));
			user.setFirst_name(rs.getString(2));
			user.setMiddle_name(rs.getString(3));
			user.setLast_name(rs.getString(4));
			user.setFather_name(rs.getString(5));
			user.setEmail_id(rs.getString(6));
			user.setMobile_number(rs.getLong(7));
			user.setAadhar_card(rs.getLong(8));
			user.setDate_of_birth(rs.getString(9));
			user.setAnnual_income(rs.getInt(10));
			user.setAddress_line_1(rs.getString(13));
			user.setAddress_line_2(rs.getString(14));
			user.setPin_code(rs.getString(15));
			user.setCity(rs.getString(16));
			user.setState(rs.getString(17));
			user.setAccount_number(rs.getLong(19));
			user.setAccount_type(rs.getString(21));
			user.setBalance(rs.getFloat(20));



			return user;
		}

	}
	
	
	class ChangeIdMapper implements RowMapper<InternetBankingUser> {
		public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			InternetBankingUser user = new InternetBankingUser();
			
			user.setUser_id(rs.getString(1));	
			



			return user;
		}

	}
	
	
	
	
	public Profile getProfileDetails(long customerAccountNumber) {
		// TODO Auto-generated method stub
		
		Profile userDetails = new Profile();
		
		String getProfileQuery="select * from gr13_customers c, gr13_addresses ad, gr13_accounts ac  where c.gc_customer_id = ad.gt_gc_customer_id  and c.gc_customer_id = ac.ga_gc_customer_id and GA_ACCOUNT_NUMBER="+customerAccountNumber; 

		
		userDetails = jdbcTemplate.queryForObject(getProfileQuery, new ProfileMapper()); 	 

		
		
		
		return userDetails;
	}
	
	public boolean checkUserId(long customerAccountNumber, String oldId) {
		
		
		String getUserIdQuery="select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber+" and GIBU_USER_ID='"+oldId+"'";

		
		List<InternetBankingUser> users = jdbcTemplate.query(getUserIdQuery, new ChangeIdMapper());
		
		if(users.size()>0)
			return true;
		
	
		
		return false;
		
		
	}
	
	
public boolean checkLoginPassword(long customerAccountNumber, String oldPassword) {
		
		
		String getLoginPasswordQuery="select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber+" and GIBU_LOGIN_PASSWORD='"+hash.getMd5(oldPassword)+"'";

		
		List<InternetBankingUser> users = jdbcTemplate.query(getLoginPasswordQuery, new ChangeIdMapper());
		
		if(users.size()>0)
			return true;
		
	
		
		return false;
		
		
	}

public boolean checkTransactionPassword(long customerAccountNumber, String oldPassword) {
	
	
	String getTransactionPasswordQuery="select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber+" and GIBU_TRANSACTION_PASSWORD='"+hash.getMd5(oldPassword)+"'";

	
	List<InternetBankingUser> users = jdbcTemplate.query(getTransactionPasswordQuery, new ChangeIdMapper());
	
	if(users.size()>0)
		return true;
	

	
	return false;
	
	
}
	
public int changeUserId(long customerAccountNumber, String newId) {
		
		
		String changeUserIdQuery="update gr13_internet_banking_users set gibu_user_id='"+newId+"' where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber;
		
		
		return jdbcTemplate.update(changeUserIdQuery);
		
		
	}


public int changeLoginPassword(long customerAccountNumber, String newPassword) {
	
	
	String changeLoginPasswordQuery="update gr13_internet_banking_users set GIBU_LOGIN_PASSWORD='"+hash.getMd5(newPassword)+"' where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber;
	
	
	return jdbcTemplate.update(changeLoginPasswordQuery);
	
	
}

public int changeTransactionPassword(long customerAccountNumber, String newPassword) {
	
	
	String changeLoginPasswordQuery="update gr13_internet_banking_users set GIBU_TRANSACTION_PASSWORD='"+hash.getMd5(newPassword)+"' where GIBU_GA_ACCOUNT_NUMBER="+customerAccountNumber;
	
	
	return jdbcTemplate.update(changeLoginPasswordQuery);
	
	
}
@Override
public void emailAccountNumber(Customer customer, Account account, Address address) {
	// TODO Auto-generated method stub
	
}
	

}  

