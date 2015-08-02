package com.learn.assessment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Question")
public class Question extends BasicEntity {


	private static final long serialVersionUID = 4671271207820584892L;

	@Id
	@Column(name = "Id")
	private Long Id;
	
	@Column(name = "description")
	private String description;

	@OneToMany
	@JoinColumn(name = "questionId")
	private Set<Choice> choices = new HashSet<Choice>(0);
		
	@Column(name = "answer")
	private String answer;

	@Column(name= "multiSelect")
	private char multiSelect = 'N';
		
	@Column(name= "subtopic")
	private String subtopic;
	
	@Transient
	private int seq;
	public Question() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Set<Choice> getChoices() {
		return choices;
	}

	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}

	public char getMultiSelect() {
		return multiSelect;
	}

	public void setMultiSelect(char multiSelect) {
		this.multiSelect = multiSelect;
	}

	public String getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	
	
}
