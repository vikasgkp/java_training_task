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
        EnrollmentKey key = enrollment.getEk();

        // Check if an enrollment with the same composite key already exists
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(key);

        if (existingEnrollment.isPresent()) {
            return "Enrollment with this Student ID and Course ID already exists";
        } else {
            // Save the new enrollment
            enrollmentRepository.save(enrollment);
            return "Student record stored successfully";
        }
    }
	


	
}
