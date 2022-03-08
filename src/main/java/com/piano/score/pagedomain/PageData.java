package com.piano.score.pagedomain;

import java.util.List;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.PageUrlList;

public class PageData {

	private List<PageUrlList> list;

	private PageMetaData metaData;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public PageData(List<PageUrlList> dataListExtract, PageMetaData metaData) {
		super();
		this.list = dataListExtract;
		this.metaData = metaData;
	}

	public List<PageUrlList> getList() {
		return list;
	}

	public void setList(List<PageUrlList> list) {
		this.list = list;
	}

	public PageMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(PageMetaData metaData) {
		this.metaData = metaData;
	}

}
