package com.piano.score.siteconnect;

import org.json.simple.JSONObject;

import com.piano.score.domain.ScoreMetaData;

public interface IMSLPConnect {
	
	
	
	String connectToIMSLP() throws Exception;
	

	String defaultUrlSetting(Integer type, Integer start);

}
