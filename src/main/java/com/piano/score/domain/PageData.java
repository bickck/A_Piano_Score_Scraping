package com.piano.score.domain;

import java.util.List;

import com.piano.score.mvc.domain.PageMetaData;
import com.piano.score.mvc.domain.PageScoreList;

public class PageData {

	private List<PageScoreList> list;

	private PageMetaData metaData;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public PageData(List<PageScoreList> list, PageMetaData metaData) {
		super();
		this.list = list;
		this.metaData = metaData;
	}

	public List<PageScoreList> getList() {
		return list;
	}

	public void setList(List<PageScoreList> list) {
		this.list = list;
	}

	public PageMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(PageMetaData metaData) {
		this.metaData = metaData;
	}

}
