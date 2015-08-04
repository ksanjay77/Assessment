package com.learn.assessment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer extends BasicEntity{

	private static final long serialVersionUID = 4786388405157535748L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long questionId;
	
	@Column(name="subtopic")
	private String subtopic;
	
	@Column(name="correct")
	private String correct;
	
	@ManyToOne
	private Result result;
	
	@Column(name="result_id",updatable=false,insertable=false)
	private Long result_id;
	

	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubtopic() {
		return subtopic;
	}
	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	public Long getResult_id() {
		return result_id;
	}
	public void setResult_id(Long result_id) {
		this.result_id = result_id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	
}
