package com.learn.assessment.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.assessment.domain.Assessment;
import com.learn.assessment.repositories.AssessmentRepository;


@Service("assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	AssessmentRepository assessmentRepository;
	
	@Override
	public Iterable<Assessment> findAll() {
		// TODO Auto-generated method stub
		return assessmentRepository.findAll();
	}

	@Override
	public Assessment find(Long id) {
		return assessmentRepository.findOne(id);
	}

	@Override
	public void saveAssessment(Assessment assessment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll(Collection<Assessment> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Collection<Assessment> entities) {
		// TODO Auto-generated method stub

	}

}
