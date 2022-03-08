package com.piano.score.mvc.repodomain.page;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Type_One_Count")
	private Long typeOneCount;

	@Column(name = "Type_Two_Count")
	private Long typeTwoCount;

	@Column(name = "Total")
	private Long total;

	public BaseInformation() {
		// TODO Auto-generated constructor stub
	}

	public BaseInformation(Long typeOneCount, Long typeTwoCount, Long total) {
		super();
		this.typeOneCount = typeOneCount;
		this.typeTwoCount = typeTwoCount;
		this.total = total;
	}

	public BaseInformation(long typeOneCount, long typeTwoCount, long total) {
		super();
		this.typeOneCount = typeOneCount;
		this.typeTwoCount = typeTwoCount;
		this.total = total;
	}
	public BaseInformation(int typeOneCount, int typeTwoCount, int total) {
		super();
		this.typeOneCount = (long) typeOneCount;
		this.typeTwoCount = (long) typeTwoCount;
		this.total = (long) total;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeOneCount() {
		return typeOneCount;
	}

	public void setTypeOneCount(Long typeOneCount) {
		this.typeOneCount = typeOneCount;
	}

	public Long getTypeTwoCount() {
		return typeTwoCount;
	}

	public void setTypeTwoCount(Long typeTwoCount) {
		this.typeTwoCount = typeTwoCount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
