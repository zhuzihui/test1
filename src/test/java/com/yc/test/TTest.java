package com.yc.test;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.bean.Account;
import com.yc.dao.AccountDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"/application.xml"})		//在另外一個src源文件下面   所以前面要加一個 /
public class TTest {
	
	@Resource(name="dataSource")
	private BasicDataSource bas;
	
	@Resource(name="sqlSessionFactory")
	private DefaultSqlSessionFactory sqlSessionFactoryBean;
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Resource(name="accountDaoImpl")
	private AccountDao accountDao;
	
	
	
	@Test
	public void test1(){
		Account a=accountDao.findAccount(1);
		System.out.println(bas);
	}
	
	@Test
	public void test2(){
		Account a=accountDao.findAccount(1);
		accountDao.updateAccount(a);

	}
	

	
}
