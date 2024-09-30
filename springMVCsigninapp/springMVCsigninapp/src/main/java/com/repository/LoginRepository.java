package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class LoginRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateUser(String emailid , String password , String typeofuser)
	{
		System.out.println("validate repository");
		String sql = "SELECT COUNT(*) FROM login WHERE emailid = ? and PASSWORD = ? and typeofuser = ?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] {emailid,password,typeofuser},Integer.class);
		return count !=null &&count >0;
	}
	
	
	public boolean saveUser(String emailid , String password , String typeofuser)
	{
		System.out.println("saveuser repository");
		String sql = "INSERT INTO login (emailid,password,typeofuser) VALUES (?, ?, ?)";

		int result = jdbcTemplate.update(sql,emailid,password,typeofuser);
		
		return result >0;
	}

}
