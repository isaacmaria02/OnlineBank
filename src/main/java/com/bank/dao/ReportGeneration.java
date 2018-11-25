package com.bank.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	

	public List<Transaction> getAccountStatement(HttpServletRequest request, HttpServletResponse response) {
	    SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");  

		
	     
		java.util.Date fromDate,toDate;
		try {
		  toDate =  (Date) formatter.parse(request.getParameter("to"))	;

			fromDate = formatter.parse(request.getParameter("from"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    List<Transaction> list= null;
	    
	    
	    //String getStatementQuery = "select * from Transactions where gt_timestamp>='"+fromDate+"' and gt_timestamp<='"+toDate+"'";
		
		//return (List<Transaction>)jdbcTemplate.query(getStatementQuery, Date.class);
	    
	    return list;
		 
	}
	
	
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
		    //transaction.setTimestamp(rs.getDate(6));
		    transaction.setRemark(rs.getString(7));
		    transaction.setCharges(rs.getFloat(7));
		    
		   
		
		    return transaction;
		  }

}
	 
	 

		public List<Transaction> getAccountStatement(Date fromDate, Date toDate) {
			// TODO Auto-generated method stub
			return null;
		}
	 
}