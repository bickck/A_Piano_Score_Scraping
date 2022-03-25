package com.piano.score.pagedomain;

import java.util.List;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.PageScoreInfos;

public class PageData {

	private List<PageScoreInfos> list;

	private PageMetaData metaData;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public PageData(List<PageScoreInfos> dataListExtract, PageMetaData metaData) {
		super();
		this.list = dataListExtract;
		this.metaData = metaData;
	}

	public List<PageScoreInfos> getList() {
		return list;
	}

	public void setList(List<PageScoreInfos> list) {
		this.list = list;
	}

	public PageMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(PageMetaData metaData) {
		this.metaData = metaData;
	}

}
