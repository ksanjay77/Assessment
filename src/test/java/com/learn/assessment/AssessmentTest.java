package com.learn.assessment;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learn.assessment.domain.Assessment;
import com.learn.assessment.domain.Question;
import com.learn.assessment.repositories.AssessmentRepository;
import com.learn.assessment.service.AssessmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@Transactional
public class AssessmentTest {

	@Autowired
	AssessmentRepository repository;
	
	@Autowired
	AssessmentService assessmentService;
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void testMethod1() {
		System.out.println("hello");
		Iterable<Assessment> ps = repository.findAll();
		for(Assessment p: ps ){	
			System.out.println("Id - "+ p.getId());
			Set<Question> questions = p.getQuestions();
			for(Question q: questions){
				System.out.print(q.getDescription());
				
			}
			System.out.println("size" + questions.size());
		}
		assessmentService.findAll();
	}
	
	
	
	
}
