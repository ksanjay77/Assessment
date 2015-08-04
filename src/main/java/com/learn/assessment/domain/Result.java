package com.learn.assessment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Result")
public class Result extends BasicEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3180729522860106204L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="accessmentCode")
	private String accessmentCode;
	
	@Column(name="assessmentId")
	private Long assessmentId;
	
	@Column(name="assessmentName")
	private String assessmentName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="result_id")
	private Set<Answer> answers = new HashSet<Answer>(0);
	
	@Column(name="userId")
	private String userId;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public String getAccessmentCode() {
		return accessmentCode;
	}

	public void setAccessmentCode(String accessmentCode) {
		this.accessmentCode = accessmentCode;
	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
