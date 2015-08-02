package com.learn.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.assessment.domain.Assessment;


public interface AssessmentRepository extends JpaRepository<Assessment, Long>{

	public Iterable<Assessment> findByName(String name); 
}
