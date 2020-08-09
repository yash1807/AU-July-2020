package com.au.hibernate.assignment.dao;

import java.util.Set;

import com.au.hibernate.assignment.model.Account;
import com.au.hibernate.assignment.model.Audit;

public interface BankTransaction {
	public abstract void makeTransaction(Account source, Account target, Integer amount, String txnPwd)  ;
	public abstract Set<Audit> getAllTransactionForUser(Integer userId);

}
