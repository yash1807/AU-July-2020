package com.au.hibernate.assignment.dao.impl;

import org.hibernate.Session;

import com.au.hibernate.assignment.dao.BankTransaction;
import com.au.hibernate.assignment.model.Account;
import com.au.hibernate.assignment.model.Audit;
import com.au.hibernate.assignment.model.User;
import com.au.hibernate.assignment.util.HibernateSessionUtil;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public class BankTransactionImpl implements BankTransaction {
 
    public final static Logger logger = Logger.getLogger(BankTransactionImpl.class);

 
    public void makeTransaction(Account source, Account target, Integer amount, String txnPwd) {    
    	Session sessionObj = HibernateSessionUtil.getSessionFactory().openSession();
        try {
            // Getting Session Object From SessionFactory
            
            sessionObj.beginTransaction();
            if(source.getAccountid() == null || target.getAccountid() == null) {
            	logger.info("Transaction failed due to dnvalid account details!!!");
            	sessionObj.getTransaction().rollback();
            }
            else if(source.getAccountBalance() >= amount && source.getTxnPwd().equals(txnPwd)) {        	           	
            	
            	Audit transactionCreate = new Audit();
            	transactionCreate.setAccBalanceInitial(source.getAccountBalance());
            	source.setAccountBalance(source.getAccountBalance() - amount);
            	transactionCreate.setAccBalanceFinal(source.getAccountBalance());  	
            	
            	
            	sessionObj.getTransaction().commit();
            	logger.info("\nTransaction Successful\n");
            	
            }  
            else if(source.getAccountBalance() < amount){
            	logger.info("\nInsufficient Account Balance\n");
            	sessionObj.getTransaction().rollback();
            	
            }
            else if(!source.getTxnPwd().equals(txnPwd)){
            	logger.info("\nIncorrect transaction paswword!!!\n");    
            	sessionObj.getTransaction().rollback();
            	
            }         

 
            
            
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    
    public Set<Audit> getAllTransactionForUser(Integer userId) {
    	Set<Audit> transactionList = new HashSet<Audit>(); 
    	Session sessionObj = HibernateSessionUtil.getSessionFactory().openSession();
    	try {
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            Set<Account> accountId = new HashSet<Account>();
            User user = sessionObj.get(User.class, userId);
            if(user != null)
            	accountId = user.getAccounts();
            for(Account account : accountId ) {
            	Set<Audit> transactions = account.getAudits();
            	for(Audit transaction : transactions ) {
            		System.out.println(transaction.toString());
            	}
            	
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
        return transactionList;
    }

}
