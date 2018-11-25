package com.bank.service;

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
		return tdao.addPayee(payee);
	}
	
	

}
