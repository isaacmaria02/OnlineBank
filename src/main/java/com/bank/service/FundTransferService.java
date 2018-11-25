package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.FundTransferDao;
import com.bank.model.Payee;
@Service
public class FundTransferService implements IFundTransferService {
	@Autowired
	FundTransferDao tdao;

	@Transactional
	public int addPayee(Payee payee) {
		System.out.println("yo");
		// TODO Auto-generated method stub
		System.out.println(payee.getCustomer_account_number()+"in ser");
		return tdao.addPayee(payee);
	}

	public int deletePayee(String name, long customerAccountNumber) {
		return tdao.deletePayee(name, customerAccountNumber);
	}

	public List<Payee> displayPayee(long accountNumber) {
		// TODO Auto-generated method stub
		return tdao.displayPayee(accountNumber);
	}

	public Payee searchPayee(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
