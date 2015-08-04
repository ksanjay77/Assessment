package com.learn.assessment.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.assessment.domain.Result;
import com.learn.assessment.repositories.ResultRepository;

@Service
@Transactional
public class ResultServiceImpl implements ResultService{

	@Autowired
	ResultRepository resultRepository;
	
	@Override
	public Result saveResult(Result arg0) {
		System.out.println(resultRepository);
		//Random r = new Random();
		//arg0.setId(r.nextLong());
		return resultRepository.save(arg0);
	}

}
