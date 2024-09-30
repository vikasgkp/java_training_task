package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.LoginService;

@Controller
public class LoginController {
	
	
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String showloginpage()
	{
		System.out.println("login controller get");
		return "login.jsp";
	}
	
	@RequestMapping(value = "signup",method = RequestMethod.GET)
	public String showsignuppage()
	{
		System.out.println("signup controller get");
		return "signup.jsp";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,Model model)
	{
		System.out.println("login controller post");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String typeofuser = request.getParameter("typeofuser");
		
		if(loginservice.Authenticate(emailid,password,typeofuser)) {
			if("admin".equals(typeofuser))
			{
				return "adminhome.jsp";
				
			}
			else 
			{
				return "customerhome.jsp";
			}
		}
		else 
		{
			
			return "failure.jsp";
		}
		
	}
	
	
	@RequestMapping(value = "signup",method = RequestMethod.POST)
	public String signup(HttpServletRequest request,Model model)
	{
		System.out.println("signup controller post");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String typeofuser = request.getParameter("typeofuser");
		if(emailid=="" || password== "") {
			System.out.println("blank enter");
			return "signup.jsp";
		}
		
		if(loginservice.register(emailid,password,typeofuser)) {
			return "login.jsp";
		}
		else 
		{
			
			return "signup.jsp";
		}
		
	}
	

}
