package com.learn.assessment.service;

import java.util.Collection;

import com.learn.assessment.domain.Assessment;

public interface AssessmentService {

	 public Iterable<Assessment> findAll();
		
	    public Assessment find(Long id);

	    public void saveAssessment(Assessment assessment);

	    public void saveAll(Collection<Assessment> entities);
	    
	    public void delete(Collection<Assessment> entities);
}
