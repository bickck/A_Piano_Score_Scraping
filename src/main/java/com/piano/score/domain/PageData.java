package com.piano.score.domain;

import java.util.List;

import com.piano.score.mvc.domain.MetaData;
import com.piano.score.mvc.domain.ScoreInfoList;

public class PageData {

	private List<ScoreInfoList> list;

	private MetaData metaData;

	public PageData() {
		// TODO Auto-generated constructor stub
	}

	public PageData(List<ScoreInfoList> list, MetaData metaData) {
		super();
		this.list = list;
		this.metaData = metaData;
	}

	public List<ScoreInfoList> getList() {
		return list;
	}

	public void setList(List<ScoreInfoList> list) {
		this.list = list;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
