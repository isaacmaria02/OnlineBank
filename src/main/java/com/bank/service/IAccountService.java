package com.bank.service;

import java.sql.SQLIntegrityConstraintViolationException;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Profile;

public interface IAccountService {

	public long openAccount(Customer customer, Account account, Address address);

	public int registerOnline(InternetBankingUser ibu) throws SQLIntegrityConstraintViolationException;

	public boolean validateUser(Login login);

	public long getAccountNumber(Login login);

	public float getBalance(long accountNumber);

	public Account getSummary(long accountNumber);

	public Profile getDetails(long customerAccountNumber);

	public boolean checkUserId(long customerAccountNumber, String oldId);

	public int changeUserId(long customerAccountNumber, String newId);

	public boolean checkLoginPassword(long customerAccountNumber, String oldPassword);

	public int changeLoginPassword(long customerAccountNumber, String newPassword);

	public boolean checkTransactionPassword(long customerAccountNumber, String oldTransactionPassword);

	public int changeTransactionPassword(long customerAccountNumber, String newTransactionPassword);

	public boolean verifyAccountNumber(InternetBankingUser ibu);

	public boolean checkDupliateId(String userId);

	public boolean validateAccountNumber(InternetBankingUser ibu);

}