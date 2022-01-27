package com.piano.score.domain;

import java.util.List;

public class ScoreListPage {

	private List<MusicScore> score;

	private ScoreMetaData metaData;

	public ScoreListPage() {
		// TODO Auto-generated constructor stub
	}

	public List<MusicScore> getScore() {
		return score;
	}

	public void setScore(List<MusicScore> score) {
		this.score = score;
	}

	public ScoreMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(ScoreMetaData metaData) {
		this.metaData = metaData;
	}

}
