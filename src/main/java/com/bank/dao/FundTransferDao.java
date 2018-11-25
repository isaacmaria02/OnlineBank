package com.bank.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bank.model.Payee;
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

}
