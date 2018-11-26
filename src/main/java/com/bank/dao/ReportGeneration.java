package com.bank.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.*;
public class ReportGeneration implements IReportGeneration {
	
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	/*public List<Transaction> getAccountStatement(HttpServletRequest request, HttpServletResponse response) {
	   

	    
	    
	    List<Transaction> list= null;
	    
	    
	    //String getStatementQuery = "select * from Transactions where gt_timestamp>='"+fromDate+"' and gt_timestamp<='"+toDate+"'";
		
		//return (List<Transaction>)jdbcTemplate.query(getStatementQuery, Date.class);
	    
	    return list;
		 
	}*/
	
	
	 class  TransactionMapper implements RowMapper<Transaction> {
		  public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {
			 Transaction transaction = new Transaction();
		    //user.setUsername(rs.getString("username"));
		  //  user.setPassword(rs.getString("password"));
		    
		    transaction.setReference_id(rs.getLong(1));
		    transaction.setType(rs.getString(2));
		    transaction.setAmount(rs.getInt(3));
		    transaction.setFrom_account(rs.getLong(4));
		    transaction.setTo_account(rs.getLong(5));
		    transaction.setTimestamp(rs.getDate(6));
		    transaction.setRemark(rs.getString(7));
		    transaction.setCharges(rs.getFloat(7));
		    
		   
		
		    return transaction;
		  }

}


	public List<Transaction> getAccountStatement(String startDate, String endDate) {
		// TODO Auto-generated method stub
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");  
		//String from = formatter.format(startDate);
		//String to =formatter.format(endDate);
	    String sartDate = "14-Nov-18";
	    String edDate = "26-Nov-18";
	    System.out.println(sartDate+" "+edDate);
		
	    String getStatementQuery = "select * from gr13_transactions where gt_timestamp>='"+sartDate+"' and gt_timestamp<='"+edDate+"'";

	    
		List<Transaction> transactionList = (List<Transaction>)jdbcTemplate.query(getStatementQuery, new TransactionMapper());

		System.out.println(transactionList.size()+" no of transactions");
         
		return transactionList;
		
	}
	public List<Transaction> getAccountStatement(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	 

		
	 
}