package com.bank.dao;

import java.util.List;

import com.bank.model.Payee;
import com.bank.model.Transaction;
/**
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 */


/**
 * Interface for Fund Transfer : Data Access Object
 */
public interface IFundTransferDao {
	public int addPayee(Payee payee);

	public int deletePayee(String name, long customerAccountNumber);

	public List<Payee> displayPayee(long accountNumber);

	public boolean confirmTransaction(Transaction tr);

	public long payeeAccountNumber(Transaction tr, long accountNumber);
	

}
