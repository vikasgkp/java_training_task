package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Enrollment;
import com.repository.EnrollmentRepository;

@Service
public class EnrollmentService {


	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	public List<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}
	
	

	
	public String EnrollStudent(Enrollment enrollment) {
		
		Optional<Enrollment> result = enrollmentRepository.findById(enrollment.getSid());
		if(result.isPresent()) {
			return "SId must be unique";
		}else {
			enrollmentRepository.save(enrollment);
			return "Student Record stored successfuly";
		}
	}
	


	
//}
