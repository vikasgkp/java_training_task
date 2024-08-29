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
	
	
//	@Transactional
//	public String deleteStudentByAge(int age) {
//		if(studentRepository.deleteStudentById(age)>0) {
//			return "Student record deleted";
//		}else {
//			return "Student record not present";
//		}
//
//	}
	
	public String storeCourses(Courses courses) {
		Optional<Courses> result = coursesRepository.findById(courses.getCid());
		if(result.isPresent()) {
			return "CId must be unique";
		}else {
			coursesRepository.save(courses);
			return "Course Record stored successfuly";
		}
	}
	
//	public String deleteStudent(int sid) {
//		Optional<Students> result = studentRepository.findById(sid);
//		if(result.isPresent()) {
//			studentRepository.deleteById(sid);
//			return "Student record deleted successfully";
//		}else {
//			return "Student record not present";
//		}
//	}
	
}
