package com.piano.score.pagedomain;

public class PageScoreList {

	private String pageId;

	private String type;

	private String parent;

	private String intvals;

	private String permlink;

	public PageScoreList() {
		// TODO Auto-generated constructor stub
	}

	public PageScoreList(String pageId, String type, String parent, String intvals, String permlink) {
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
