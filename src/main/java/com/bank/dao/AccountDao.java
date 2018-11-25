package com.bank.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException.*; 
import org.springframework.jdbc.core.ResultSetExtractor;import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;


public class AccountDao implements IAccountDao
{
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int createAccount(Customer customer, Account account, Address address)
	{
		int i=0;
		
		String getCustomerId= "select GR13_customers_seq.nextval from dual";
	      long customerId = getCustomerSeq(getCustomerId);
	
		
		String getAccountNumber= "select GR13_accounts_seq.nextval from dual";
		long accountNumber = getCustomerSeq(getAccountNumber);
		
		
		String getAddressId= "select GR13_addresses_seq.nextval from dual";
		long addressId = getCustomerSeq(getAddressId);
		
		
		String customerTableQuery="insert into GR13_customers values("+customerId+",'"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"',"+customer.getMobile_number()+","+customer.getAadhar_card()+",'"+customer.getDate_of_birth()+"',"+customer.getAnnual_income()+")";

		i= jdbcTemplate.update(customerTableQuery);
		
		
	    
		
		String accountTableQuery="insert into GR13_accounts values("+accountNumber+",50000,'SAVINGS',"+customerId+")";

		i =  jdbcTemplate.update(accountTableQuery);
	     
		
		
		String addressTableQuery="insert into GR13_addresses values("+addressId+",'"+address.getAddress_line_1()+"','"+address.getAddress_line_2()+"',"+address.getPin_code()+",'"+address.getCity()+"','"+address.getState()+"',"+customerId+")";
		
	//	String query="insert into customers values('"+rf.getUserId()+"','"+rf.getMobileNo()+"','"+rf.getAmount()+"','"+rf.getOperator()+"')";
		
		i =  jdbcTemplate.update(addressTableQuery);
	    	
		return i;
	}
	
	
	//search account number before this
	
	public int register(InternetBankingUser ibu)
	{
		int i =0;
		
		
		
		String register="insert into GR13_internet_banking_users values('"+ibu.getUser_id()+"','"+ibu.getLogin_password()+"','"+ibu.getTransaction_password()+"',0,'enabled','"+ibu.getSecurity_questions()+"','"+ibu.getSecurity_answers()+"',"+ibu.getAccount_number()+")";
		i= jdbcTemplate.update(register);		
		
		
		return i;
		
	}
	
	
	public boolean Login(Login login)
	{
		boolean isValidate= validateUser(login);
		
		
		
		return isValidate;
		
	}
	
	
	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub
		
		
		
        String getAccountNumberQuery="select GIBU_GA_ACCOUNT_NUMBER from gr13_internet_banking_users where gibu_user_id='"+login.getUser_id()+"'"; 
		 
		long accountNumber =jdbcTemplate.queryForObject(getAccountNumberQuery, Long.class); 	 
		 
		System.out.println(accountNumber+" got it?");
		return accountNumber;
		
		
	}

	
	
	
	
	
	
	/*
	public List<RechargeForm> getAllTransaction(RechargeForm rf){  
		 String sql="select * from Transactions where mobile=?"; 
		 
		 return jdbcTemplate.query(sql, new Object[] {rf.getMobileNo()}, new RowMapper<RechargeForm>(){  
			    public RechargeForm mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        RechargeForm e=new RechargeForm();  
			      //  e.setMobileNo(rs.getInt(2)); 
			        e.setMobileNo(rs.getLong(2));
                     e.setAmount(rs.getInt(3));
                     e.setOperator(rs.getString(4));
                     
                    
			        System.out.println(e.getAmount());
			        return e;  
			    }  
			    }); 		 
		 
	 }  
	
	public User checkBalance(RechargeForm rf){  
		System.out.println("inside dao"+rf.getUserId());
		 String sql="select * from users where users_pk="+rf.getUserId(); 
		 
		 return (User)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class) ); 	 
		 
	 }
	
	public int updateBalance(int balance, RechargeForm rf){  
		System.out.println("inside update balance "+balance +" "+rf.getUserId());
	    String sql="update Users set balance='"+balance+"' where users_pk="+rf.getUserId()+"";  
	    return jdbcTemplate.update(sql);  
	}  
	
*/
	
         private long getCustomerSeq(String query) {
		
		long res = jdbcTemplate.queryForObject(query, Long.class);
		return res;
	}
	
	     public boolean validateUser(Login login) {
		    String sql = "select * from GR13_internet_banking_users where GIBU_USER_ID='" + login.getUser_id() + "' and GIBU_LOGIN_PASSWORD='" + login.getPassword()
		    + "'";
		    List<InternetBankingUser> users = jdbcTemplate.query(sql, new UserMapper());
		    return users.size() > 0 ? true : false;
		    }
	 
	 class UserMapper implements RowMapper<InternetBankingUser> {
		  public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			  InternetBankingUser user = new InternetBankingUser();
		    //user.setUsername(rs.getString("username"));
		  //  user.setPassword(rs.getString("password"));
		    
		    user.setUser_id(rs.getString(1));
		    user.setLogin_password(rs.getString(2));
		   
		
		    return user;
		  }
		  
	 }

	
	 
	
	 
}  

