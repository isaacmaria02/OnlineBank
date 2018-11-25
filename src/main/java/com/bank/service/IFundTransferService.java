package com.bank.service;

import java.util.List;

import com.bank.model.Payee;

public interface IFundTransferService {
	
	public int addPayee(Payee payee);

	public int deletePayee(String name, long customerAccountNumber);
	
	public List<Payee> displayPayee(long accountNumber);
	



}
