package com.piano.score.httpconnection;

import com.piano.score.domain.ScoreMetaData;

public interface IMSLPConnect {
	
	
	
	void connecting() throws Exception;
	
	ScoreMetaData getScoreMetaData(int start);

	String defaultUrlSetting(Integer type, Integer start);

}
