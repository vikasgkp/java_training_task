package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Courses;
import com.service.CoursesService;

@RestController
public class CoursesController {
	
	@Autowired
	CoursesService coursesService;
	
	// http://localhost:8080/students
	
	@RequestMapping(value = "courses",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Courses> findAll() {
		return coursesService.findAll();
	}
	
//	http://localhost:9090/storestudent
	@RequestMapping(value = "storecourse",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Courses courses) {
		return coursesService.storeCourses(courses);
	}
	
	


}
