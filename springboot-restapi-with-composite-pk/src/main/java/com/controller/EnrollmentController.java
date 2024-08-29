package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Enrollment;
import com.service.EnrollmentService;

@RestController
public class EnrollmentController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	// http://localhost:8080/students
	
	@RequestMapping(value = "enroll",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> findAll() {
		return enrollmentService.findAll();
	}
	
//	http://localhost:9090/storestudent
	@RequestMapping(value = "enrollstudent",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Enrollment enrolllment) {
		return enrollmentService.EnrollStudent(enrolllment);
	}
	
	

}
