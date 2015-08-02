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
import com.learn.assessment.service.AssessmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@Transactional
public class QuestionTest {

	
	@Autowired
	AssessmentService service;
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void testMethod1() {
		System.out.println("hello");
		Assessment ps = service.find(1L);
			Set<Question> questions = ps.getQuestions();
			for(Question q: questions){
				System.out.print(q.getDescription());
			}
			System.out.println("size" + questions.size());
	}
}
