package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Profile;

@Service
public class AccountService implements IAccountService {

	@Autowired
	AccountDao edao;

	@Transactional
	public long openAccount(Customer customer, Account account, Address address) {
		// TODO Auto-generated method stub
		return edao.createAccount(customer, account, address);
	}

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

	@Transactional
	public boolean checkUserId(long customerAccountNumber, String oldId) {
		// TODO Auto-generated method stub

		return edao.checkUserId(customerAccountNumber, oldId);
	}

	@Transactional
	public boolean checkLoginPassword(long customerAccountNumber, String oldPassword) {
		// TODO Auto-generated method stub

		return edao.checkLoginPassword(customerAccountNumber, oldPassword);
	}

	@Transactional
	public int changeUserId(long customerAccountNumber, String newId) {
		// TODO Auto-generated method stub

		return edao.changeUserId(customerAccountNumber, newId);
	}

	@Transactional
	public int changeLoginPassword(long customerAccountNumber, String newPassword) {
		// TODO Auto-generated method stub

		return edao.changeLoginPassword(customerAccountNumber, newPassword);
	}

	@Transactional
	public boolean checkTransactionPassword(long customerAccountNumber, String oldPassword) {
		// TODO Auto-generated method stub

		return edao.checkTransactionPassword(customerAccountNumber, oldPassword);
	}

	@Transactional
	public int changeTransactionPassword(long customerAccountNumber, String newPassword) {
		// TODO Auto-generated method stub

		return edao.changeTransactionPassword(customerAccountNumber, newPassword);
	}

	@Override
	public boolean verifyAccountNumber(InternetBankingUser ibu) {
		// TODO Auto-generated method stub
		return edao.verifyAccountNumber(ibu);
	}

	@Override
	public boolean checkDupliateId(String userId) {
		// TODO Auto-generated method stub
		return edao.checkDupliateId(userId);
	}

	@Override
	public boolean validateAccountNumber(InternetBankingUser ibu) {
		// TODO Auto-generated method stub
		return edao.validateAccountNumber(ibu);
	}

	@Override
	public boolean validateAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return edao.validateAccountNumber(accountNumber);
	}

	@Override
	public String getSecurityQuestion(long account_number) {
		// TODO Auto-generated method stub
		
		return edao.getSecurityQuestion(account_number);
	}

	@Override
	public boolean verifySecurityAnswer(InternetBankingUser ibu) {
		// TODO Auto-generated method stub
		return edao.verifySecurityAnswer(ibu);
	}

	public String getForgottenUserId(long account_number) {
		// TODO Auto-generated method stub
		
		return edao.getForgottenUserId(account_number);
	
		
	}

	

}