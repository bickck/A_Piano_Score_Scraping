package com.piano.score.web.netconnect;

import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.piano.score.mvc.repodomain.page.PageMetaData;

/**
 * 
 * @author DongHyeon_Kim
 * 
 * 이 문서는 URL를 통해 웹을 연결해줍니다.
 * 
 * 갱신일 : 2022-03-15
 */


public interface ImslpConnection {

	String connectSiteGetJson(int type, int start) throws Exception;
	
	String connectSiteGetData(String url) throws Exception;

}
