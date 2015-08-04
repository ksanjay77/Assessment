package com.learn.assessment;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learn.assessment.domain.Answer;
import com.learn.assessment.domain.Assessment;
import com.learn.assessment.domain.Question;
import com.learn.assessment.domain.Result;
import com.learn.assessment.service.AssessmentService;
import com.learn.assessment.service.ResultService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@Transactional
public class QuestionTest {

	
	@Autowired
	AssessmentService service;
	
	@Autowired
	ResultService rservice;
	
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
	
	@Test
	@Rollback(false)
	@Transactional(propagation = Propagation.REQUIRED)
	public void testMethod2() {
		Result r = new Result();
		//r.setId(1L);
		r.setAssessmentId(1L);
		r.setAssessmentName("Physics");
		r.setUserId("admin");
		Answer a = new Answer();
		a.setCorrect("C");
		a.setSubtopic("Hello");
		//a.setId(1L);
		a.setQuestionId(1L);
		a.setResult(r);
		Set<Answer> answers = new HashSet<Answer>(0);
		answers.add(a);
		r.setAnswers(answers);
		 rservice.saveResult(r);
	}
	
	
}
