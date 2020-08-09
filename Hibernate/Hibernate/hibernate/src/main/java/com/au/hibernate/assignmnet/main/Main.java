package com.au.hibernate.assignmnet.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.apache.log4j.Logger;

import com.au.hibernate.assignment.dao.impl.BankTransactionImpl;
import com.au.hibernate.assignment.model.Account;
import com.au.hibernate.assignment.model.Audit;
import com.au.hibernate.assignment.model.User;
import com.au.hibernate.assignment.util.HibernateSessionUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session sessionObj = HibernateSessionUtil.getSessionFactory().openSession();
		sessionObj.beginTransaction();
		
		final Logger logger = Logger.getLogger(BankTransactionImpl.class);
		
			
		
			
			//Create Users
			User user1 = new User();
			user1.setUserName("Yash Rai");
			user1.setUserAddress("Varanasi");
			user1.setUserContact("9876543210");	
			User user2 = new User();
			user2.setUserName("Jennifer Evert");
			user2.setUserAddress("Delhi");
			user2.setUserContact("9876543209");
			
			
			//Create Accounts		
			Account acc1user1 = new Account();
			acc1user1.setAccountBalance(10000);
			acc1user1.setAccountType("Savings");
			acc1user1.setTxnPwd("transferBalance");
			
			
			Account acc2user1 = new Account();
			acc2user1.setAccountBalance(10030);
			acc2user1.setAccountType("Current");
			acc2user1.setTxnPwd("balanceDone");
			
			Account acc1user2 = new Account();
			acc1user2.setAccountBalance(10010);
			acc1user2.setAccountType("Savings");
			acc1user2.setTxnPwd("balance");
	
			
			Account acc2user2 = new Account();
			acc2user2.setAccountBalance(30000);
			acc2user2.setAccountType("Savings");
			acc2user2.setTxnPwd("transferdone");
			
			
			//Create transactions
			Audit audit1= new Audit();
			audit1.setAccBalanceFinal(10000);
			audit1.setAccBalanceInitial(11000);
			
			Audit audit2= new Audit();
			audit2.setAccBalanceFinal(11000);
			audit2.setAccBalanceInitial(13000);
			
			Audit audit3= new Audit();
			audit3.setAccBalanceFinal(10010);
			audit3.setAccBalanceInitial(11000);
			
			Audit audit4= new Audit();
			audit4.setAccBalanceFinal(10030);
			audit4.setAccBalanceInitial(11000);
			
			Audit audit5= new Audit();
			audit5.setAccBalanceFinal(30000);
			audit5.setAccBalanceInitial(41000);	
			
			Set<Account> user1Accounts = new HashSet<Account>();
			Set<Account> user2Accounts = new HashSet<Account>();
			
			Set<Audit> user1Acc1Txn = new HashSet<Audit>();
			Set<Audit> user1Acc2Txn = new HashSet<Audit>();
			Set<Audit> user2Acc1Txn = new HashSet<Audit>();
			Set<Audit> user2Acc2Txn = new HashSet<Audit>();
			
			user1Acc1Txn.add(audit1);
			user1Acc1Txn.add(audit2);
			user1Acc2Txn.add(audit3);
			user2Acc1Txn.add(audit4);
			user2Acc2Txn.add(audit5);
			
			acc1user1.setAudits(user1Acc1Txn);		
			acc2user1.setAudits(user1Acc2Txn);
			acc1user2.setAudits(user2Acc1Txn);
			acc2user2.setAudits(user2Acc2Txn);
			
			
			user1Accounts.add(acc1user1);
			user1Accounts.add(acc2user1);
			user2Accounts.add(acc1user2);
			user2Accounts.add(acc2user2);
			
			user1.setAccounts(user1Accounts);
			user1.setAccounts(user2Accounts);
			
			try{
				sessionObj.save(user1);
				sessionObj.save(user2);
				
				sessionObj.getTransaction().commit();
				
			}catch(Exception sqlException) {
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
			
			BankTransactionImpl transactionObj = new BankTransactionImpl();
			transactionObj.makeTransaction(acc2user1, acc2user2, 30, "balanceDone");//Successful			
			transactionObj.makeTransaction(acc2user1, acc2user2, 30, "balanceDone1"); //Unsuccessful - incorrect txn pwd
			transactionObj.makeTransaction(acc1user2, acc2user2, 30000, "balance");//Unsuccessful - Insufficient Balance
			
			
			HashSet<Audit> allTxn = (HashSet<Audit>) transactionObj.getAllTransactionForUser(user1.getUserId());
			
			for(Audit transactions : allTxn) {
				System.out.println(transactions.toString());
			}
			
		
		
		
		
		


	}

}
