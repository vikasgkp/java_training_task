package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	CoursesRepository coursesRepository;
	
	public List<Courses> findAll() {
		return coursesRepository.findAll();
	}
	
	
	
	public String storeCourses(Courses courses) {
		Optional<Courses> result = coursesRepository.findById(courses.getCid());
		if(result.isPresent()) {
			return "CId must be unique";
		}else {
			coursesRepository.save(courses);
			return "Course Record stored successfuly";
		}
	}
	
	
}
