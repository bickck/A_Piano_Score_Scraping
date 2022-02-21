package com.piano.score.pagedomain;

import java.util.List;

import com.piano.score.mvc.repodomain.page.MetaData;
import com.piano.score.mvc.repodomain.page.ScoreList;

public class PageData {

	private List<ScoreList> list;

	private MetaData metaData;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public PageData(List<ScoreList> dataListExtract, MetaData metaData) {
		super();
		this.list = dataListExtract;
		this.metaData = metaData;
	}

	public List<ScoreList> getList() {
		return list;
	}

	public void setList(List<ScoreList> list) {
		this.list = list;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
