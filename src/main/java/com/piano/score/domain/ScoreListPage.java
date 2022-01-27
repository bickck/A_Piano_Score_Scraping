package com.piano.score.domain;

import java.util.List;

public class ScoreListPage {

	private List<PageScoreList> score;

	private PageMetaData metaData;

	public ScoreListPage() {
		// TODO Auto-generated constructor stub
	}

	public List<PageScoreList> getScore() {
		return score;
	}

	public void setScore(List<PageScoreList> score) {
		this.score = score;
	}

	public PageMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(PageMetaData metaData) {
		this.metaData = metaData;
	}

}
