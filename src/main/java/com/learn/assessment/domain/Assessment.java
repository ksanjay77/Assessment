package com.learn.assessment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Assessment")
public class Assessment extends BasicEntity {

	private static final long serialVersionUID = -6100203914082015702L;

	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "name")
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ASSESSMENTQUESTION", joinColumns = { @JoinColumn(name = "AssessmentID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "QuestionID", nullable = false, updatable = false) })
	private Set<Question> questions = new HashSet<Question>(0);

	@Column(name="topic")
	private String topic;
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
}
