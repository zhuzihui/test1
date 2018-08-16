package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.Account;
import com.yc.dao.AccountDao;

@Repository		//spring托管
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao {

	
	@Resource(name = "sqlSession")   //因为  SqlSessionDaoSuppport这个父类需要  sqlsession,所以要注入
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);   //调用父类的set方法完成注入
	}
	
	
	@Override
	public void updateAccount(Account account) {
		super.getSqlSession().update("com.yc.dao.mapper.accountDaoMapper.updateAccount",account );
	}

	@Override
	public Account findAccount(int accountid) {
		Account account=(Account)super.getSqlSession().selectOne("com.yc.dao.mapper.accountDaoMapper.findAccount", accountid);
		return account;
	}

}
