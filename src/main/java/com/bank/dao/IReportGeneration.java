package com.bank.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.model.Transaction;

public interface IReportGeneration {
	
	
	public List<Transaction> getAccountStatement(@RequestParam("from") @DateTimeFormat(pattern="dd-MMM-YY") Date fromDate, @RequestParam("to") @DateTimeFormat(pattern="dd-MMM-YY") Date toDate);

}
