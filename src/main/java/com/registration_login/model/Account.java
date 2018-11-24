package com.registration_login.model;

import java.util.List;

;

public class Account {
	
   private int  account_number;	
	private int balance;
	private String account_type;
	int customer_id;
	
	
	

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", balance=" + balance + ", account_type=" + account_type
				+ ", customer_id=" + customer_id + "]";
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	

	


	

}
