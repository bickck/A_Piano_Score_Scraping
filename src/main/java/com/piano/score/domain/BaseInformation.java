package com.piano.score.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseInformation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Type_One_Count")
	private int typeOneCount;

	@Column(name = "Type_Two_Count")
	private int typeTwoCount;

	public BaseInformation(int typeOneCount, int typeTwoCount) {
		super();
		this.typeOneCount = typeOneCount;
		this.typeTwoCount = typeTwoCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTypeOneCount() {
		return typeOneCount;
	}

	public void setTypeOneCount(int typeOneCount) {
		this.typeOneCount = typeOneCount;
	}

	public int getTypeTwoCount() {
		return typeTwoCount;
	}

	public void setTypeTwoCount(int typeTwoCount) {
		this.typeTwoCount = typeTwoCount;
	}

}
