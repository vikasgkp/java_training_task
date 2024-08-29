package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Students;
import com.service.StudentsService;

@RestController
public class StudentsController {

	@Autowired
	StudentsService studentService;
	
	// http://localhost:8080/students
	
	@RequestMapping(value = "students",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Students> findAll() {
		return studentService.findAll();
	}
	
//	http://localhost:9090/storestudent
	@RequestMapping(value = "storestudent",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Students student) {
		return studentService.storeStudent(student);
	}
	
	
	

}