package com.yc.advices;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class Myjob {
	public void hello(){
		System.out.println("0000");		
	}
	
	public String backUpDb(){
		try {
			Runtime.getRuntime().exec("mysqldump -hlocalhost -P3306 -uroot -pa --database test >d:/a.sql");
			System.out.println("备份成功。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
