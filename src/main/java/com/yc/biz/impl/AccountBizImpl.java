package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Account;
import com.yc.bean.OpRecord;
import com.yc.biz.AccountBiz;
import com.yc.dao.AccountDao;
import com.yc.dao.OpRecordDao;
import com.yc.dao.impl.AccountDaoImpl;
import com.yc.dao.impl.OpRecordDaoImpl;


@Transactional(readOnly=true,propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)		//默认事务	在类上配置的事务机制在每个方法都起作用
@Service
public class AccountBizImpl implements AccountBiz {
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setOpRecordDao(OpRecordDao opRecordDao) {
		this.opRecordDao = opRecordDao;
	}

	@Resource(name="accountDaoImpl")
	private AccountDao accountDao=new AccountDaoImpl();
	
	@Resource(name="opRecordDaoImpl")
	private OpRecordDao opRecordDao=new OpRecordDaoImpl();
	

	@Override	//加入事务
	public void deposite(int accountid, double money) {
		Account a=accountDao.findAccount(accountid);
		if(a==null){
			throw new RuntimeException("查无此账户..");
			
		}
		a.setBalance(money);
		accountDao.updateAccount(a);
		
		OpRecord oprecord=new OpRecord();
		oprecord.setAccountid(accountid);
		oprecord.setOpmoney(money);
		opRecordDao.insertOpRecord(oprecord);
	}

	@Override
	public void withdraw(int accountid, double money) {
		Account a=accountDao.findAccount(accountid);
		if(a==null){
			throw new RuntimeException("查无此账户..");
		}
		if(a.getBalance()<money){
			throw new RuntimeException("余额不足..");
		}
		double qumoney=-money;
		a.setBalance(qumoney);
		accountDao.updateAccount(a);
		
		OpRecord oprecord=new OpRecord();
		oprecord.setAccountid(accountid);
		oprecord.setOpmoney(qumoney);
		opRecordDao.insertOpRecord(oprecord);
	}

	@Override
	public void transfer(int inAccountid, int outAccountid, double money) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Account findAccount(int accountid) {
		return accountDao.findAccount(accountid);
	}

	@Override
	public Account openAccount(double money) {
		return null;
	}

}
