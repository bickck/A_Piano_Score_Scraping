package com.piano.score.log.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "RECOREDLOG")
public class RecordException {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Exception_Locate")
	private Long location;

	@CreationTimestamp
	private Timestamp createTime;

	@Override
	public String toString() {
		return "RecordException [id=" + id + ", location=" + location + ", createTime=" + createTime + "]";
	}

	public RecordException() {
		
	}

	public RecordException(Long location) {
		this.location = location;
	}

	public RecordException(int id, Long location) {
		this.id = id;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
