package com.piano.score.mvc.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.piano.score.mvc.repodomain.page.OutPutDataList;
import com.piano.score.mvc.repodomain.page.ScoreList;

public interface WebDataService {

	Long typeOneDataCount() throws Exception;

	Long typeTwoDataCount() throws Exception;

	void allWebDataCollect(int type) throws Exception;
	
	OutPutDataList saveTest(int type);

}
