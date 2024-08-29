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
	
	
//	@Transactional
//	public String deleteStudentByAge(int age) {
//		if(studentRepository.deleteStudentById(age)>0) {
//			return "Student record deleted";
//		}else {
//			return "Student record not present";
//		}
//
//	}
	
	public String EnrollStudent(Enrollment enrollment) {
		
//		Optional<Enrollment> result = enrollmentRepository.findById(enrollment.getSid());
//		if(result.isPresent()) {
//			return "SId must be unique";
//		}else {
			enrollmentRepository.save(enrollment);
			return "Student Record stored successfuly";
		}
	}
	
//	public String EnrollStudent(int sid,int cid, int year) {
//		if(enrollmentRepository.existsByStudentIdandCoursesId(sid, cid ))
//		{
//			return "SId and Cid must be unique";
//		}
//			
//			Enrollment enrollment = new Enrollment();
////			enrollment.setStudent(Students);
////			enrollment.setCourse(courses);
////			enrollment.setYear(year);
//			enrollmentRepository.save(enrollment);
//			return "Enroll Record stored successfuly";
//		
//	}
//	
//	
//	
////	public String deleteStudent(int sid) {
////		Optional<Students> result = studentRepository.findById(sid);
//		if(result.isPresent()) {
//			studentRepository.deleteById(sid);
//			return "Student record deleted successfully";
//		}else {
//			return "Student record not present";
//		}
//	}
	
//}
