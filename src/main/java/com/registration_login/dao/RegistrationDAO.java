package com.registration_login.dao;


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

import com.registration_login.model.Account;
import com.registration_login.model.Address;
import com.registration_login.model.Customer;
import com.registration_login.model.InternetBankingUser;


public class RegistrationDAO 
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
		System.out.println("in save data..");
		String customerTableQuery="insert into g13_customers values('+g13_customer_seq.nextval+','"+customer.getFirst_name()+"','"+customer.getMiddle_name()+"','"+customer.getLast_name()+"','"+customer.getFather_name()+"','"+customer.getEmail_id()+"','"+customer.getMobile_number()+"','"+customer.getAadhar_card()+"','"+customer.getDate_of_birth()+"','"+customer.getAnnual_income()+"')";

		i= jdbcTemplate.update(customerTableQuery);
		
		
	    
		
		String accountTableQuery="insert into g13_accounts values('+g13_account_seq.nextval+','"+account.getAccount_type()+"','"+50000+"','+g13_customer_seq.currval')";

		i =  jdbcTemplate.update(accountTableQuery);
	     
		
		
		String addressTableQuery="insert into g13_addresses values('+g13_address_seq.nextval+','"+address.getAddress_line_1()+"','"+address.getAddress_line_2()+"','"+address.getCity()+"','"+address.getPin_code()+"','"+address.getState()+"','+g13_customer_seq.currval')";
		
	//	String query="insert into customers values('"+rf.getUserId()+"','"+rf.getMobileNo()+"','"+rf.getAmount()+"','"+rf.getOperator()+"')";
		
		i =  jdbcTemplate.update(addressTableQuery);
	    	
		return i;
	}
	
	
	//search account number before this
	
	public int register(InternetBankingUser ibu)
	{
		int i =0;
		String register="insert into g13_internet_banking_users values('"+ibu.getUser_id()+"','"+ibu.getLogin_password()+"','"+ibu.getTransaction_password()+"','"+ibu.getAttempts()+"','"+ibu.getStatus()+"','"+ibu.getSecurity_questions()+"','"+ibu.getSecurity_answers()+"','"+ibu.getAccount_number()+"')";

	//	i= jdbcTemplate.update(register);
		
		
		
		return i;
		
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
}  