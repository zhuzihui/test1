package com.yc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.Student;

@Controller
@SessionAttributes("student")		//必须要是和类名一样，且新new的对象名也是这个样子（即就是对象名第一个字母小写），然后将其存到HttpSession中，可以直接在jsp页面中调用
public class PersonController {
	
	@RequestMapping(value={"/person"})		//匹配路径
	public String t1(@RequestHeader(value="Host",required=true) String host,
			@RequestHeader("User-Agent") String useragent,String sid,String sname,
			Student stu){
		System.out.println(host);
		System.out.println(useragent);
		System.out.println("student："+stu);
		System.out.println(sid);
		
		return "success";
	}
	
	@RequestMapping(value="/person1")
	public String t2(Model model,Student stu){
		model.addAttribute("stu", stu);				//Model对象addAttribute方法可以存到HttpSession中，因此可以在jsp页面取到
		System.out.println(stu);
		model.addAttribute("aa", "123");
		return "success";
	}
	@RequestMapping(value="/person2")
	public ModelAndView t3(Student stu,ModelAndView model){
		model.addObject("stu", stu);				//Model对象addAttribute方法可以存到HttpSession中，因此可以在jsp页面取到
		System.out.println(stu);
		model.setViewName("success");
		return model;
	}
	
	@RequestMapping(value="/person3")
	public String t3(Student student){
		System.out.println(student);
		return "success";
	}
	
	@RequestMapping(value="/person4")
	@ResponseBody								//表示返回一个json数据		---------重要方法！
	public void t4(Student student){
		System.out.println(student);
		
	}
	
}
