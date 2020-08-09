package com.au.hibernate.assignment.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table (name = "user")
public class User {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")	
	private int userId;
	
	@Column(name = "User_name")
	private String userName;
	
	@Column(name = "User_contact")
	private String userContact;
	
	@Column(name = "User_address")
	private String userAddress;

	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="User_id")
	private Set<Account> accounts;

	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	

}
