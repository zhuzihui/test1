package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yc.biz.StudentBiz;
import com.yc.dao.StudentDao;
import com.yc.dao.impl.StudentDaoImpl;

@Repository
public class StudentBizImpl implements StudentBiz{
	
	//缺点：1.studentbizimpl是直接依赖与studentdaoimpl类
	
//	@Autowired			//<property name="studentDao" ref="studentDaoImpl" >
//	@Qualifier("studentRedisDaoImpl")
//	@Resource(name="studentRedisDaoImpl")		//不是spring的方法   是javax的   和上面俩个不一样
	private StudentDao studentDao=new StudentDaoImpl();	//studentdao类接口
	@Override
	public void find() {
		studentDao.find();
		
	}

	@Override
	public void add() {
		
		studentDao.add();
	}
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


}
