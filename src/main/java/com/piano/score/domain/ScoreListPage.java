package com.piano.score.domain;

import java.util.List;

public class ScoreListPage {

	private List<Score> score;

	private ScoreMetaData metaData;

	public ScoreListPage() {
		// TODO Auto-generated constructor stub
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}

	public ScoreMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(ScoreMetaData metaData) {
		this.metaData = metaData;
	}

}
