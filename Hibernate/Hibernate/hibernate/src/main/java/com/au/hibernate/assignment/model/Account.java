package com.au.hibernate.assignment.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Account_id")
	private Integer accountid;
	
//	@Column(name = "User_id")
//	private Integer userId;
	
	@Column(name = "Account_type")
	private String accountType;
	
	@Column(name = "Account_balance")
	private Integer accountBalance;
	
	@Column(name = "Transaction_Passwords")
	private String txnPwd;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Account_id")
	private Set<Audit> audits;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Audit> getAudits() {
		return audits;
	}
	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getTxnPwd() {
		return txnPwd;
	}
	public void setTxnPwd(String txnPwd) {
		this.txnPwd = txnPwd;
	}
	
	

}
