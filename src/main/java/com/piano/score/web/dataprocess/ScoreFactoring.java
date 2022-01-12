package com.piano.score.web.dataprocess;

import java.util.List;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;

public class ScoreFactoring {

	private ScoreListPage listPage;

	public ScoreFactoring(List<Score> lists, ScoreMetaData metaData) {
		// TODO Auto-generated constructor stub
		this.listPage.setScore(lists);
		this.listPage.setMetaData(metaData);
	}

	public ScoreFactoring() {
		// TODO Auto-generated constructor stub
	}

	public ScoreListPage getListPage() {
		return listPage;
	}

	public void setListPage(ScoreListPage listPage) {
		this.listPage = listPage;
	}
	
	

}
