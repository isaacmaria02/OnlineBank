package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.AdminDao;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Admin;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Profile;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminDao addao;
	


	@Transactional
	public List<Profile> displayRequests() {
		// TODO Auto-generated method stub
		return addao.displayRequests();
	}
	
	
	

	@Transactional
	public int reject(int i) {
		// TODO Auto-generated method stub
		return addao.reject(i);
	}
	
	
	
	

	@Transactional
	public int approve(int i) {
		// TODO Auto-generated method stub
		return addao.approve(i);
	}
/*
	@Transactional
	public int registerOnline(InternetBankingUser ibu) {
		// TODO Auto-generated method stub
		return edao.register(ibu);
	}

	@Transactional
	public boolean validateUser(Login login) {
		// TODO Auto-generated method stub
		return edao.login(login);
	}

	@Transactional
	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub

		return edao.getAccountNumber(login);
	}

	
	@Transactional
	public float getBalance(long accountNumber) {
		// TODO Auto-generated method stub

		return edao.checkBalance(accountNumber);
	}

	@Override
	public Account getSummary(long accountNumber) {
		// TODO Auto-generated method stub
		return edao.getSummary(accountNumber);
	}	
	
	@Transactional
	public Profile getDetails(long customerAccountNumber) {
		// TODO Auto-generated method stub

		return edao.getProfileDetails(customerAccountNumber);
	}
*/
	
	
}