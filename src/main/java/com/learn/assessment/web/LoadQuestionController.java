package com.learn.assessment.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.learn.assessment.domain.Assessment;
import com.learn.assessment.domain.Question;
import com.learn.assessment.domain.Result;
import com.learn.assessment.service.AssessmentService;

@RestController
public class LoadQuestionController {

	private AssessmentService assessmentService;
	
	/**
	 * Creates a new LoanController with a given loan number.
	 */
	@Autowired
	public LoadQuestionController(AssessmentService assessmentService) {
		this.assessmentService = assessmentService;
	}
	
	
	@RequestMapping(value="/assessment", method=RequestMethod.GET) 
	public @ResponseBody Assessment assessmentDetails(@RequestParam("Id") Long id) {
		
		System.out.println("Entering.........assessmentDetails............");
		
		return assessmentService.find(id); 
	}
	
	@RequestMapping(value="/assessment/{Id}", method=RequestMethod.GET) 
	public @ResponseBody Assessment assessmentDetail(@PathVariable("Id") Long id) {
		
		System.out.println("Entering....assessmentDetail.................");
		Assessment assessment = assessmentService.find(id);
		int count = 0;
		Set<Question> questions = assessment.getQuestions();
		for(Question q:questions){
			q.setSeq(count);
			count++;
		}
		return  assessment;
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/assessmentList",method=RequestMethod.GET)
	public HttpEntity<Iterable<Assessment>> assessmentList() {
		Iterable<Assessment> list = assessmentService.findAll();
		
		System.out.println("Entering....assessmentList.................");
		
		return new ResponseEntity<Iterable<Assessment>>(list,HttpStatus.OK );
		//return list;
	}
	
	@RequestMapping(value="/assessment",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createAssessment(@RequestBody Assessment assessment, 
			  HttpServletRequest request, 
			  HttpServletResponse response) {
		
		assessmentService.saveAssessment(assessment);;
		response.setHeader("Location", getLocationForChildResource(request, assessment.getId()));
	}
	
	@RequestMapping(value="/assessment/{Id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAssessment(@PathVariable("Id") Long Id) {
		//inplement remove;
		
	}
	
	/**
	 * Maps IllegalArgumentExceptions to a 404 Not Found HTTP status code.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({IllegalArgumentException.class})
	public void handleNotFound() {
		// just return empty 404
	}

	/**
	 * Maps DataIntegrityViolationException to a 409 Conflict HTTP status code.
	 */
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({DataIntegrityViolationException.class})
	public void handleAlreadyExists() {
		// just return empty 409
	}
	
	/**
	 * determines URL of child resource based on the full URL of the given request,
	 * appending the path info with the given childIdentifier using a UriTemplate.
	 */ 
	private String getLocationForChildResource(HttpServletRequest request, Object childIdentifier) {
		StringBuffer url = request.getRequestURL();
		UriTemplate template = new UriTemplate(url.append("/{childId}").toString());
		return template.expand(childIdentifier).toASCIIString();
	}	
}
