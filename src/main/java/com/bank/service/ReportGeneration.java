package com.bank.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.dao.IReportGeneration;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.Payee;
import com.bank.model.Transaction;



@Service
public class ReportGeneration  {

	@Autowired
	ReportGeneration rdao;
/*
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public Employee getEmployee(int empid) {
		return employeeDAO.getEmployee(empid);
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public int openAccount(Customer customer, Account account, Address address) {
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

	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub
		
		return edao.getAccountNumber(login);
	}
*/
	@Transactional

	public List<Transaction> getAccountStatement(Date from, Date to) {
		// TODO Auto-generated method stub
		return rdao.getAccountStatement(from,to);
	}


	
}