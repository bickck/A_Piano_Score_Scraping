package com.piano.score.domain;

public class Score {

	private Long id;

	private String scoreId;

	private String type;

	private String parent;

	private String intvals;

	private String permlink;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(Long id, String scoreId, String type, String parent, String intvals, String permlink) {
		super();
		this.id = id;
		this.scoreId = scoreId;
		this.type = type;
		this.parent = parent;
		this.intvals = intvals;
		this.permlink = permlink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getIntvals() {
		return intvals;
	}

	public void setIntvals(String intvals) {
		this.intvals = intvals;
	}

	public String getPermlink() {
		return permlink;
	}

	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

}
