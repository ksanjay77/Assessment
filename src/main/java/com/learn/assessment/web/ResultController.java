package com.learn.assessment.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.assessment.domain.Answer;
import com.learn.assessment.domain.Result;
import com.learn.assessment.service.ResultService;

@RestController
public class ResultController {

	@Autowired
	private ResultService service;
	
	@RequestMapping(value="/evaluate",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void evaluate(@RequestBody Result result, HttpServletRequest request, 
			  HttpServletResponse response) {
		for(Answer a:result.getAnswers()){
			a.setResult(result);
		}
		service.saveResult(result);
	}

}
