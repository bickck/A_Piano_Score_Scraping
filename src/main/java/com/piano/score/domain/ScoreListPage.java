package com.piano.score.domain;

public class ScoreListPage {

	private Score score;

	private ScoreMetaData metaData;

	public ScoreListPage() {
		// TODO Auto-generated constructor stub
	}

	public ScoreListPage(Score score, ScoreMetaData metaData) {
		super();
		this.score = score;
		this.metaData = metaData;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public ScoreMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(ScoreMetaData metaData) {
		this.metaData = metaData;
	}
}
