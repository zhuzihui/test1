package com.yc.biz;

import com.yc.bean.Account;

public interface AccountBiz {
	public void deposite(int accountid,double money);	//存
	public void withdraw(int accountid,double money);	//取
	public void transfer(int inAccountid,int outAccountid,double money);	//转
	public Account findAccount(int accountid);		//查
	public Account openAccount(double money);	//开户
}
