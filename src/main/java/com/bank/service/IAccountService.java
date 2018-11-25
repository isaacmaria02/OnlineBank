package com.bank.service;


import java.util.List;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;


public interface IAccountService {
	
	public int openAccount(Customer customer,Account account,Address address);
	
	
	public int registerOnline(InternetBankingUser ibu);
	
	public boolean validateUser(Login login);
	
	public long getAccountNumber(Login login);
	

	/*public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);*/
}