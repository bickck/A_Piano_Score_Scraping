package com.piano.score.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PAGE_ID")
	private String pageId;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "PARENT")
	private String parent;

	@Column(name = "INTVALS")
	private String intvals;

	@Column(name = "PERMLINK")
	private String permlink;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(String pageId, String type, String parent, String intvals, String permlink) {
		super();

		this.pageId = pageId;
		this.type = type;
		this.parent = parent;
		this.intvals = intvals;
		this.permlink = permlink;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
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
