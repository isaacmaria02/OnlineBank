package com.bank.dao;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

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
