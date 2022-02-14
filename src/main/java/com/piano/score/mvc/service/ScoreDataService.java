package com.piano.score.mvc.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.piano.score.mvc.repositorydomain.ScoreInfoList;

public interface ScoreDataService {

	Long typeOneDataCount() throws Exception;

	Long typeTwoDataCount() throws Exception;

	void allWebDataCollect(int type) throws Exception;

	void connectTest() throws Exception;

}
