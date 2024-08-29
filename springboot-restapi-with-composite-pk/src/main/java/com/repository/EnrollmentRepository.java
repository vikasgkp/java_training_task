package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	
	//boolean existsByStudentIdandCoursesId(int sid,int cid);

}
