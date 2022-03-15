package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repodomain.page.PageUrlList;
import com.piano.score.pagedomain.PageData;

/*
 * 
 * 이 문서는 JSON데이터를 저장 가능한 형태로 바꿔주는 역할을 합니다.
 * 
 * 갱신일 2022-02-03
 */


public interface DataExtract {

	WebPageData pageDataExtract(int type ,int start) throws Exception;
	
	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
