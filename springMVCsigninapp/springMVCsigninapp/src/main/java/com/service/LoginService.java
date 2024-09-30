package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginrepository;
	
	
	public boolean Authenticate(String emailid , String password , String typeofuser)
	{
		System.out.println("authenticate service");
		return loginrepository.validateUser(emailid, password,typeofuser);
	}
	
	public boolean register(String emailid , String password , String typeofuser)
	{
		System.out.println("register service");
		return loginrepository.saveUser(emailid, password,typeofuser);
	}
}
