/*package com.yc.services;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.Account;
import com.yc.biz.AccountBiz;

//mvc架构不需要写这个servlet	都是直接注入调用

@WebServlet("/account.action")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//获取spring容器
		WebApplicationContext wac=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		String op=request.getParameter("op");
		int accountid=Integer.parseInt(request.getParameter("accountid"));
		double money=Double.parseDouble(request.getParameter("money"));
		if(op.equals("deposite")){
//			Account a=(Account) wac.getBean("account");
//			a.setAccountid(accountid);
//			a.setBalance(money);
//			System.out.println(a);
			
			//----------------------为什么不直接注入---------------
			AccountBiz a1= (AccountBiz) wac.getBean("accountBizImpl");
			System.out.println(a1.toString());
			a1.withdraw(accountid, money);
			System.out.println("ok");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		
		
	}

}
*/