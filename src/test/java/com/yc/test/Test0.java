package com.yc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.advices.Email;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"beans*.xml"})
public class Test0 {
	
	@Test
	public void t1() throws Exception{
		Email e=new Email();
		e.main(null);
	}
}
