package com.yc.bean;

import java.io.Serializable;

public class Account implements Serializable{
	
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer accountid;
	private Double balance;
	
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
	
}
