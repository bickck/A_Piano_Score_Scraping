package com.piano.score.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;

public interface ScoreDataService {

	ScoreListPage connect();

	int typeOneAllCount() throws Exception;

	int typeTwoAllCount() throws Exception;

	Score findScoreList(String reqScoreName);

	List<Score> lists();

}
