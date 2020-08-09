package com.au.hibernate.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
	

@Entity
@Table (name = "audit")
public class Audit {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Audit_id")		
	private int auditId;
	
//	@Column(name = "Account_id")
//	private int accountId;
	
	@Column(name = "Acc_balance_initial")
	private int accBalanceInitial;
	
	@Column(name = "Acc_balance_final")
	private int accBalanceFinal;
	
	@ManyToOne
	private Account account;
	
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
//	public int getAccountId() {
//		return accountId;
//	}
//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}
	public int getAccBalanceInitial() {
		return accBalanceInitial;
	}
	public void setAccBalanceInitial(int accBalanceInitial) {
		this.accBalanceInitial = accBalanceInitial;
	}
	public int getAccBalanceFinal() {
		return accBalanceFinal;
	}
	public void setAccBalanceFinal(int accBalanceFinal) {
		this.accBalanceFinal = accBalanceFinal;
	}

}
