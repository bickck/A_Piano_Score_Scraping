package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repodomain.page.PageUrlList;
import com.piano.score.pagedomain.PageData;

public interface DataExtract {

	WebPageData pageDataExtract(int type ,int start) throws Exception;
	
	

	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
