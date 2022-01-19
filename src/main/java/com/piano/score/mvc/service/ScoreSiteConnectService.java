package com.piano.score.mvc.service;

import org.springframework.stereotype.Service;

import com.piano.score.domain.ScoreListPage;

public interface ScoreSiteConnectService {

	ScoreListPage connect();

	int dataCount(int type);

}
