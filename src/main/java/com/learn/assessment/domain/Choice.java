package com.learn.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Choice")
public class Choice implements Serializable{

	private static final long serialVersionUID = 7077409926386789320L;

	@Id
	private int id;
	
	@Column(name = "description",  length = 500)
	private String description;
	
	@Transient
	private String userChoice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
