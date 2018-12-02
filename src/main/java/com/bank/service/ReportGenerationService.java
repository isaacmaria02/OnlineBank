package com.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Transaction;

@Service
public class ReportGenerationService implements IReportGenerationService {

	@Autowired
	ReportGenerationService rdao;

	@Transactional

	public List<Transaction> getAccountStatement(Date from, Date to, long accountNumber) {
		// TODO Auto-generated method stub
		return rdao.getAccountStatement(from, to, accountNumber);
	}

	@Override
	public void generateReport() {

	}

}