package com.piano.score.domain;

public class ScoreMetaData {

	private Long id;
	private int start;
	private int limit;
	private String sortBy;
	private String sortDirection;
	private boolean moreResultAvailable;
	private Long timeStamp;
	private int version;

	public ScoreMetaData() {
		// TODO Auto-generated constructor stub
	}

	public ScoreMetaData(Long id, int start, int limit, String sortBy, String sortDirection, boolean moreResultAvailable,
			Long timeStamp, int version) {
		super();
		this.id = id;
		this.start = start;
		this.limit = limit;
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
		this.moreResultAvailable = moreResultAvailable;
		this.timeStamp = timeStamp;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
