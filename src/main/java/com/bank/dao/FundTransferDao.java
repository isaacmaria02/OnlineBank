package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Payee;
import com.bank.model.Transaction;
import com.bank.service.IFundTransferService;

public class FundTransferDao implements IFundTransferService {
	
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	 public int addPayee(Payee payee)
	 {
			int i =0;
			
			System.out.println("hows u");
			System.out.println(payee.getCustomer_account_number());
			
			
			String addPayeeQuery="insert into GR13_payee values("+payee.getPayee_account_number()+",'"+payee.getName()+"','"+payee.getNick_name()+"',"+payee.getCustomer_account_number()+")";
			i= jdbcTemplate.update(addPayeeQuery);		
			
			
			return i;
	 }
	 
	 
	 
	 public int deletePayee(String name, long customerAccountNumber)
	 {
			int i =0;
			
			
			
			
			String deletePayeeQuery="delete from gr13_payee where gp_name='"+name+"' and GP_GC_CUSTOMER_ACCOUNT_NUMBER="+customerAccountNumber;
			i= jdbcTemplate.update(deletePayeeQuery);		
			
			
			return i;
	 }
	 
	public List<Payee> displayPayee(long accountNumber) {
		// TODO Auto-generated method stub
	
		 String getPayeeQuery="select * from gr13_payee where GP_GC_CUSTOMER_ACCOUNT_NUMBER="+accountNumber; 


		 
		 
		 
		 
		 return jdbcTemplate.query(getPayeeQuery, new RowMapper<Payee>(){  
			    public Payee mapRow(ResultSet rs, int rownumber) throws SQLException {  
			       Payee payee=new Payee(); 
                   payee.setPayee_account_number(rs.getLong(1));
			       payee.setName(rs.getString(2));
			       payee.setNick_name(rs.getString(3));			       
			       
			       
			        return payee;  
			    }  
			    }); 	
	}
	
	
	public boolean confirmTransaction(Transaction tr, long accountNumber) {
		// TODO Auto-generated method stub
	
		 String getPayeeQuery="select * from gr13_payee where GP_GC_CUSTOMER_ACCOUNT_NUMBER="+tr; 


		 
		 
		 
		 
		 return false; 	
	}
	


	public long payeeAccountNumber(Transaction tr, long accountNumber) {
		
		System.out.println(tr.getPayee_name()+" inside dao");
		// TODO Auto-generated method stub
		 String getPayeeQuery="select GP_PAYEE_ACCOUNT_NUMBER from gr13_payee where GP_GC_CUSTOMER_ACCOUNT_NUMBER="+accountNumber+" and gp_name='"+tr.getPayee_name()+"'"; 


		 
			long payeeAccountNumber =  jdbcTemplate.queryForObject(getPayeeQuery, Long.class);
			
			 
			System.out.println("inside fund transfer dao "+payeeAccountNumber); 
			
			return payeeAccountNumber;
	}
	
	
	}


