package com.learn.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.assessment.domain.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{

}
