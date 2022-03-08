package com.piano.score.mvc.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repodomain.page.PageUrlList;

public interface WebDataService {

	void allWebDataCollect(int type, int start) throws Exception;

	Long pageTypeDataAllCount(int type) throws Exception;

}
