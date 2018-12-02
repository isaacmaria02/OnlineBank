package com.bank.dao;

import java.util.List;

import com.bank.model.Transaction;

/**
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 */

/**
 * Interface for Report Generation : Data Access Object
 */
public interface IReportGeneration {

	List<Transaction> getAccountStatement(String startDate, String endDate, long accountNumber);

}
