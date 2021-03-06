package com.bank.service;

import java.util.List;

import com.bank.model.Payee;
import com.bank.model.Transaction;

public interface IFundTransferService {

	public int addPayee(Payee payee);

	public int deletePayee(String name, long customerAccountNumber);

	public List<Payee> displayPayee(long accountNumber);

	public boolean confirmTransaction(Transaction tr, long accountNumber);

	public float calculateCharges(Transaction tr);

}
