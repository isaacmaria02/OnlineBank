package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.*;

public class ReportGeneration implements IReportGeneration {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class TransactionMapper implements RowMapper<Transaction> {
		public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {
			Transaction transaction = new Transaction();

			transaction.setReference_id(rs.getLong(1));
			transaction.setType(rs.getString(2));
			transaction.setAmount(rs.getInt(3));
			transaction.setFrom_account(rs.getLong(4));
			transaction.setTo_account(rs.getLong(5));
			transaction.setTimestamp(rs.getDate(6));
			transaction.setRemark(rs.getString(7));
			transaction.setCharges(rs.getFloat(8));

			return transaction;
		}

	}

	public List<Transaction> getAccountStatement(String startDate, String endDate, long accountNumber) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");

		String getStatementQuery = "select * from gr13_transactions where gt_timestamp between '" + startDate
				+ "' and '" + endDate + "' and gt_ga_from_account=" + accountNumber;

		List<Transaction> transactionList = (List<Transaction>) jdbcTemplate.query(getStatementQuery,
				new TransactionMapper());

		return transactionList;

	}

}