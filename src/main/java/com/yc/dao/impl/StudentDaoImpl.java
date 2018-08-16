package com.yc.dao.impl;


import org.springframework.stereotype.Repository;

import com.yc.dao.StudentDao;


@Repository
public class StudentDaoImpl implements StudentDao{

	@Override
	public void add() {
		System.out.println("添加了");
		
	}

	@Override
	public void find() {
		System.out.println("查找了");
		
	}

}
