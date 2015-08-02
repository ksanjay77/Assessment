package com.learn.assessment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer extends BasicEntity{

	private static final long serialVersionUID = 4786388405157535748L;
	
	@Id
	private Long id;
	
	@Column(name="subtopic")
	private String subtopic;
	
	@Column(name="correct")
	private String correct;
	
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
		
}
