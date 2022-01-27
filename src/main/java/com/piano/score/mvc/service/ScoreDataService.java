package com.piano.score.mvc.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.piano.score.domain.PageScoreList;
import com.piano.score.domain.ScoreListPage;

public interface ScoreDataService {

	Long typeOneDataCount() throws Exception;

	Long typeTwoDataCount() throws Exception;

	void allWebDataCollect();

	void connectTest() throws ParseException;

}
