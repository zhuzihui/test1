package com.yc.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.bean.Account;
import com.yc.bean.JsonModel;
import com.yc.biz.AccountBiz;

@Controller
@SessionAttributes("account")		//必须要是和类名一样，且新new的对象名也是这个样子（即就是对象名第一个字母小写），然后将其存到HttpSession中，可以直接在jsp页面中调用
public class AccountControllers {
	
	@Resource(name="accountBizImpl")		//di根据spring容器自动注入
	private AccountBiz accountBiz;
	
	@RequestMapping(value="/deposite")
	@ResponseBody
	public JsonModel show(JsonModel json,Account account){
		System.out.println(account);
		try {
			accountBiz.deposite(account.getAccountid(), account.getBalance());
			json.setCode(1);
			json.setObj(account);
		} catch (Exception e) {
			json.setCode(0);
			json.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/a")
	//@ResponseBody
	public JsonModel show1(JsonModel json){
		System.out.println("----a-------");
		try {
			Account account=accountBiz.findAccount(1);
			json.setCode(1);
			json.setObj(account);
		} catch (Exception e) {
			json.setCode(0);
			json.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}

}
