package com.piano.score.mvc.repodomain.page;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.piano.score.web.convert.ResultAvailableConvert;

@Entity
public class PageMetaData {

	@Id
	@Column(name = "PAGE_START")
	private int start;

	@Column(name = "PAGE_LIMIT")
	private int limit;

	@Column(name = "PAGE_SORTBY")
	private String sortBy;

	@Column(name = "PAGE_SORTDIRECTION")
	private String sortDirection;

	@Column(name = "PAGE_RESULTAVAILABLE")
	// @Convert(converter = ResultAvailableConvert.class)
	private boolean moreResultAvailable;

	@Column(name = "PAGE_TIMESTAMP")
	private Long timeStamp;

	@Column(name = "PAGE_VERSION")
	private Integer version;

	public PageMetaData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ScoreMetaData [start=" + start + ", limit=" + limit + ", sortBy=" + sortBy + ", sortDirection="
				+ sortDirection + ", moreResultAvailable=" + moreResultAvailable + ", timeStamp=" + timeStamp
				+ ", version=" + version + "]";
	}

	public PageMetaData(int start, int limit, String sortBy, String sortDirection, Boolean moreResultAvailable,
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

	public boolean isMoreResultAvailable() {
		return moreResultAvailable;
	}

	public void setMoreResultAvailable(boolean moreResultAvailable) {
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
