package com.piano.score.siteconnect;

import org.json.simple.JSONObject;

import com.piano.score.domain.ScoreMetaData;

public interface IMSLPConnect {
	
	
	
	JSONObject connecting() throws Exception;
	
	ScoreMetaData getScoreMetaData(JSONObject jsonObject) throws Exception;

	String defaultUrlSetting(Integer type, Integer start);

}
