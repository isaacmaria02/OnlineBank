package com.bank.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.FundTransferDao;
import com.bank.model.Payee;
import com.bank.model.Transaction;
@Service
public class FundTransferService implements IFundTransferService {
	@Autowired
	FundTransferDao tdao;
	
	@Autowired
	AccountDao edao;

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

	public synchronized boolean confirmTransaction(Transaction tr, long userAccountNumber) {
		
		//GENERATING REFERENCE ID
		long referenceId = generateRandom(12);
		tr.setReference_id(referenceId);
		
		
		//FINDING PAYEE ACCOUNT NUMBER
	   long accountNumber=tdao.payeeAccountNumber(tr, userAccountNumber);
		System.out.println(accountNumber);
		
		
		//FINDING TRANSACTION CHARGES
		
		
		
		//GENERATING TIMESTAMP		
		
		return false;
		//return tdao.confirmTransaction(tr);
	}


	public static long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}

	
	
	

}
