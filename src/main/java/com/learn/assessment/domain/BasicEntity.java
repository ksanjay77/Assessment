package com.learn.assessment.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasicEntity implements Serializable {

	private static final long serialVersionUID = -4915214494836487663L;

	public abstract Long getId();

	public abstract void setId(Long id);

	@Override
	public boolean equals(Object arg0) {

		if (arg0 == null || !(arg0 instanceof BasicEntity))
			return false;
		if (((BasicEntity) arg0).getId() == this.getId() || this == arg0)
			return true;

		return false;
	}
	
}
