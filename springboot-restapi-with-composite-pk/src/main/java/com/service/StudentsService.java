package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Students;
import com.repository.StudentsRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentsService {

	@Autowired
	StudentsRepository studentRepository;
	
	public List<Students> findAll() {
		return studentRepository.findAll();
	}
	

	
	public String storeStudent(Students student) {
		Optional<Students> result = studentRepository.findById(student.getSid());
		if(result.isPresent()) {
			return "SId must be unique";
		}else {
			studentRepository.save(student);
			return "Student Record stored successfuly";
		}
	}
	
	
	
}