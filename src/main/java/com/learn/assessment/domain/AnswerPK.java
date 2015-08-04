package com.learn.assessment.domain;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerPK {

	private Long id;
	private Long result_id;

	public AnswerPK(){}

	public AnswerPK(Long id, Long result_id) {
		super();
		this.id = id;
		this.result_id = result_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResult_id() {
		return result_id;
	}

	public void setResult_id(Long result_id) {
		this.result_id = result_id;
	}
	
}
