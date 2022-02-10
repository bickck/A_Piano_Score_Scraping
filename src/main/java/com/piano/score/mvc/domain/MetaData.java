package com.piano.score.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.piano.score.domain.ResultAvailableConvert;

@Entity
public class MetaData {

	@Id
	@Column(name = "START")
	private Integer start;
	
	@Column(name ="LIMIT")
	private Integer limit;
	
	@Column(name ="SORTBY")
	private String sortBy;
	
	@Column(name ="SORTDIRECTION")
	private String sortDirection;
	
	@Column(name ="MORERESULTAVAILABLE")
	//@Convert(converter = ResultAvailableConvert.class)
	private String moreResultAvailable;
	
	@Column(name ="TIMESTAMP")
	private Long timeStamp;
	
	@Column(name ="VERSION")
	private Integer version;

	public MetaData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ScoreMetaData [start=" + start + ", limit=" + limit + ", sortBy=" + sortBy + ", sortDirection="
				+ sortDirection + ", moreResultAvailable=" + moreResultAvailable + ", timeStamp=" + timeStamp
				+ ", version=" + version + "]";
	}

	public MetaData(int start, int limit, String sortBy, String sortDirection, String moreResultAvailable,
			long timeStamp, int version) {
		super();
		this.start = start;
		this.limit = limit;
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
		this.moreResultAvailable = moreResultAvailable;
		this.timeStamp = timeStamp;
		this.version = version;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String isMoreResultAvailable() {
		return moreResultAvailable;
	}

	public void setMoreResultAvailable(String moreResultAvailable) {
		this.moreResultAvailable = moreResultAvailable;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
